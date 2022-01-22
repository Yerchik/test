package Yerchik.services.implementation;

import Yerchik.dao.CryptoCarrencyDao;
import Yerchik.dao.PricesDao;
import Yerchik.entity.Prices;
import Yerchik.services.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricesServiceImpl implements PricesService {
    @Autowired
    private PricesDao pricesDao;

    @Autowired
    private CryptoCarrencyDao cryptoCarrencyDao;

    public void addPrice(double value, String nameOfCarrency) {
        pricesDao.add(new Prices(value, cryptoCarrencyDao.findByName(nameOfCarrency)));
    }

    public List<Double> findPricesesByName(String nameOfCarrency) {
        List<Double> prices = new ArrayList<>();
        for (Prices pr : pricesDao.findPricesesByCarrency(cryptoCarrencyDao.findByName(nameOfCarrency))) {
            prices.add(pr.getV());
        }
        return prices;
    }

    public double lastValue(String nameOfCarrency) {
        List<Prices> list = pricesDao.findPricesesByCarrency(cryptoCarrencyDao.findByName(nameOfCarrency));
        return list.get(list.size() - 1).getV();
    }

    @Override
    public List<Double> findByNamePageSize(String nameOfCarrency, int page, int size) {
        List<Double> result = new ArrayList<>();
        List<Prices> prices = pricesDao.findPricesesByCarrency(cryptoCarrencyDao.findByName(nameOfCarrency));
        if (prices.size() < ((page + 1) * size)) {
            for (int i = (page * size); i < prices.size(); i++) {
                result.add(prices.get(i).getV());
            }
        } else {
            for (int i = (page * size); i < ((page + 1) * size); i++) {
                result.add(prices.get(i).getV());
            }
        }
        List<Double> sortedResult = result.stream().sorted().collect(Collectors.toList());
        return sortedResult;
    }
}
