package Yerchik.services;

import Yerchik.entity.CryptoCarrency;

import java.util.List;

public interface CryptoCarrencyService {
    void edit(String n, double maxV, double minV);

    CryptoCarrency findByName(String name);

    List<String> allCarrencyName();

    //List<CryptoCarrency> allCarrency();


}
