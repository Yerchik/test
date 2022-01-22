package Yerchik.dao.implementation;

import Yerchik.dao.PricesDao;
import Yerchik.entity.CryptoCarrency;
import Yerchik.entity.Prices;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PricesDaoImpl implements PricesDao {

    @PersistenceContext(unitName = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Prices prices) {
        entityManager.persist(prices);
    }

    @Transactional
    public List<Prices> findPricesesByCarrency(CryptoCarrency carrency) {
        return (List<Prices>) entityManager.createQuery("SELECT c FROM Prices c WHERE c.currency = :carrency ")
                .setParameter("carrency", carrency).getResultList();
    }
}
