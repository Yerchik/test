package Yerchik.dao.implementation;

import Yerchik.dao.CryptoCarrencyDao;
import Yerchik.entity.CryptoCarrency;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CryptoCarrencyDaoImpl implements CryptoCarrencyDao {
    @PersistenceContext(name = "Main")
    private EntityManager entityManager;

    @Transactional
    public void edit(CryptoCarrency cryptoCarrency) {
        entityManager.merge(cryptoCarrency);
    }

    @Transactional
    public CryptoCarrency findByName(String n) {
        return (CryptoCarrency) entityManager.createQuery("SELECT c FROM CryptoCarrency  c WHERE c.n = :n")
                .setParameter("n", n).getSingleResult();
    }

    @Transactional
    public List<CryptoCarrency> allCarency() {
        return (List<CryptoCarrency>)  entityManager.createQuery("SELECT c FROM CryptoCarrency c ")
                .getResultList();
    }
}
