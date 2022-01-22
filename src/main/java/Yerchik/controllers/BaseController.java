package Yerchik.controllers;

import Yerchik.app.FindValue;
import Yerchik.entity.CryptoCarrency;
import Yerchik.services.CryptoCarrencyService;
import Yerchik.services.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Controller
public class BaseController {

    @Autowired
    CryptoCarrencyService cryptoCarrencyService;

    @Autowired
    PricesService pricesService;




    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String homePage(Model model) throws IOException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                List<String> allCarrencyName = cryptoCarrencyService.allCarrencyName();
                for (String carr : allCarrencyName) {
                    double value = 0;
                    try {
                        value = FindValue.findValue(carr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    CryptoCarrency carrency = cryptoCarrencyService.findByName(carr);
                    if(value>carrency.getMaxV())
                        cryptoCarrencyService.edit(carr, value, carrency.getMinV());
                    if (value<carrency.getMinV() || carrency.getMinV()==0)
                        cryptoCarrencyService.edit(carr, carrency.getMaxV(), value);

                    if (pricesService.lastValue(carr) != value)
                        pricesService.addPrice(value, carr);
                }
            }
        }, 0, 60000);


        for (String cry:cryptoCarrencyService.allCarrencyName()) {
            model.addAttribute(cry, pricesService.findPricesesByName(cry).size());
        }
        model.addAttribute("carrencies", cryptoCarrencyService.allCarrencyName());
        return "home";
    }

    @RequestMapping(value = "/cryptocurrencies/minpricename={carrency}", method = RequestMethod.GET)
    private String minPage(@PathVariable String carrency,Model model){
        model.addAttribute("carrency", carrency);
        String min = "" + cryptoCarrencyService.findByName(carrency).getMinV();
        model.addAttribute("min", min);
        return "min";
    }

    @RequestMapping(value = "/cryptocurrencies/maxpricename={carrency}", method = RequestMethod.GET)
    private String maxPage(@PathVariable String carrency,Model model){
        model.addAttribute("carrency", carrency);
        String max = "" + cryptoCarrencyService.findByName(carrency).getMaxV();
        model.addAttribute("max", max);
        return "max";
    }

    @RequestMapping(value = "//cryptocurrencies/name={carrency}&page={pages}&size={size}", method = RequestMethod.GET)
    private String prices(@PathVariable String carrency,@PathVariable String pages, @PathVariable String size, Model model){
        model.addAttribute("carrency", carrency);
        List<Double> prices = pricesService.findByNamePageSize(carrency,Integer.parseInt(pages),Integer.parseInt(size));
        model.addAttribute("prices", prices);
        return "prices";
    }


}
