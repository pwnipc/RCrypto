package dao;

import models.Prices;

import java.util.List;

public interface PricesDao {
    void addPrice(Prices price);

    List<String> getAllPlaces();
}
