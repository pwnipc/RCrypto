package services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PriceApiClient {
    private static PriceApiClient instance = null;
    private PriceApi priceApi;

    private PriceApiClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(PriceApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        priceApi = retrofit.create(PriceApi.class);
    }

    public static synchronized PriceApiClient getInstance() {
        if (instance == null) {
            instance = new PriceApiClient();
        }
        return instance;
    }

    public PriceApi getPriceApi() {
        return priceApi;
    }
}
