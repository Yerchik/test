package Yerchik.dao;

import Yerchik.entity.CryptoCarrency;

import java.util.List;

public interface CryptoCarrencyDao {
    void edit(CryptoCarrency cryptoCarrency);
    CryptoCarrency findByName(String n);
    List<CryptoCarrency> allCarency();
}
