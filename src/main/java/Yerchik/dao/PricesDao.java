package Yerchik.dao;

import Yerchik.entity.CryptoCarrency;
import Yerchik.entity.Prices;

import java.util.List;

public interface PricesDao {
    void add(Prices prices);
    List<Prices> findPricesesByCarrency(CryptoCarrency carrency);
}
