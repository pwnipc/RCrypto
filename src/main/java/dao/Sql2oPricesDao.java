package dao;

import com.google.gson.Gson;
import models.Prices;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPricesDao implements PricesDao{
    private final Sql2o sql2o;

    public Sql2oPricesDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public static void getDrivers(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPrice(Prices price) {
        getDrivers();

        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO prices (price) VALUES (:price)";
            int id = (int) conn.createQuery(sql, true)
                    .addParameter("price",new Gson().toJson(price))
                    .executeUpdate()
                    .getKey();
            price.setId(id);
        }catch(Sql2oException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<String> getAllPlaces() {
        getDrivers();

        try(Connection conn = sql2o.open()){
            String sql = "SELECT price FROM prices";
            return conn.createQuery(sql)
                    .executeAndFetch(String.class);
        }
    }
}
