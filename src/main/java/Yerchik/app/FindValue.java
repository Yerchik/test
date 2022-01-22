package Yerchik.app;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class FindValue {
    public static double findValue(String nameOfCarrency) throws IOException {
        String page = "https://coinmarketcap.com/currencies/"+nameOfCarrency+"/";
        Connection conn = Jsoup.connect(page);
        Document doc = conn.get();
        String result = String.valueOf(doc.body().getElementsByClass("priceValue "));
        result = result.replaceAll("<[^>]*>", "");
        result = result.replaceAll("[$]","");
        result = result.replaceAll("[,]","");
        double d = Double.parseDouble(result);
        return d;
    }
}
