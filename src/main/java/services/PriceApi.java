package services;

import models.Prices;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface PriceApi {
    //"https://api.coingecko.com/api/v3/simple/price?ids=bitcoin%2Cethereum&vs_currencies=usd";
    String BASE_URL = "https://api.coingecko.com/api/v3/";
    @Headers("accept: application/json")
    @GET("simple/price")
    Call<Prices> getPrices(@Query("ids") String ids, @Query("vs_currencies") String currencies);
}
