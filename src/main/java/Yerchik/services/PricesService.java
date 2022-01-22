package Yerchik.services;

import Yerchik.entity.Prices;
import org.springframework.security.access.method.P;

import java.util.List;

public interface PricesService {
    void addPrice(double value, String nameOfCarrency);

    List<Double> findPricesesByName(String nameOfCarrency);

    double lastValue(String nameOfCarrency);

    List<Double> findByNamePageSize(String nameOfCarrency, int page, int size);



}
