package Yerchik.services.implementation;

import Yerchik.dao.CryptoCarrencyDao;
import Yerchik.entity.CryptoCarrency;
import Yerchik.services.CryptoCarrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoCarrencyServiceImp implements CryptoCarrencyService {

    @Autowired
    private CryptoCarrencyDao cryptoCarrencyDao;

    public void edit(String n, double maxV, double minV) {
        CryptoCarrency cry = cryptoCarrencyDao.findByName(n);
        cry.setMaxV(maxV);
        cry.setMinV(minV);
        cryptoCarrencyDao.edit(cry);
    }

    public CryptoCarrency findByName(String name) {
        return cryptoCarrencyDao.findByName(name);
    }

    public List<String> allCarrencyName() {
        List<String> allCarr = new ArrayList<String>();
        for(CryptoCarrency cryp : cryptoCarrencyDao.allCarency()){
            allCarr.add(cryp.getN());
        }
        return allCarr;
    }


}
