package Yerchik.app;

import Yerchik.entity.CryptoCarrency;
import Yerchik.entity.Prices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Main");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       CryptoCarrency btc = new CryptoCarrency("Bitcoin", 0, 0, new ArrayList<Prices>());
        CryptoCarrency eth = new CryptoCarrency("Ethereum", 0, 0, new ArrayList<Prices>());
        CryptoCarrency xrp = new CryptoCarrency("XRP", 0, 0, new ArrayList<Prices>());
        entityManager.getTransaction().begin();
        entityManager.merge(btc);
        entityManager.merge(eth);
        entityManager.merge(xrp);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.println(FindValue.findValue("bitcoin"));
    }
}
