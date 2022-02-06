import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.Sql2oPricesDao;
import models.Prices;
import org.sql2o.Sql2o;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.PriceApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        String connectionString = "jdbc:postgresql://:5432/<Database-Name>?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
        Sql2o sql2o = new Sql2o(connectionString,"<Database-User-Name>","<Database-Password");
        Sql2oPricesDao pricesDao = new Sql2oPricesDao(sql2o);
        Gson gson = new Gson();

        get("/",(request, response)->"<h1 style=\"text-align: center;\"><a href=\"https://github.com/Chal13W1zz/RCrypto#readme\">API Documentation</a></h1>");


        get("/records/sync",(request, response)->{
            Map<String, Object> model = new HashMap<>();

// Fetch prices from the api and save to the database
            Call<Prices> call = PriceApiClient.getInstance().getPriceApi().getPrices("bitcoin,ethereum","usd");

            call.enqueue(new Callback<Prices>() {

                @Override
                public void  onResponse(Call<Prices> call, Response<Prices> response) {
                    Prices pr = response.body();
                    pricesDao.addPrice(pr);

                }

                @Override
                public void onFailure(Call<Prices> call, Throwable t) {
                    System.out.println("Something went wrong");
                    model.put("error","Something went wrong");
                }
            });

//return the last json record from the database
            List<String> savedPrices = pricesDao.getAllPlaces();
            response.status(200);
            response.type("application/json");
            return savedPrices.get(savedPrices.size() - 1);

        });

//Create Manual price records
        post("/records/add", "application/json", (request, response) -> {
            Prices manualRecord = gson.fromJson(request.body(), Prices.class);
            pricesDao.addPrice(manualRecord);
            response.status(201);
            response.type("application/json");
            return gson.toJson(manualRecord);
        });

        get("/records/view",(request, response)->{
            Map<String, Object> model = new HashMap<>();

//display saved currencies from the database
           List<String> savedPrices = pricesDao.getAllPlaces();
           ArrayList<Prices> cryptoPrices = new ArrayList<>();
           
            for(int i = 1; i < savedPrices.size(); i++){
                String stringifiedPrice = savedPrices.get(i);
                Prices priceObj = gson.fromJson(stringifiedPrice,Prices.class);
                cryptoPrices.add(priceObj);
            }

            response.status(200);
            response.type("application/json");
            return gson.toJson(cryptoPrices) ;
        });
    }

}
