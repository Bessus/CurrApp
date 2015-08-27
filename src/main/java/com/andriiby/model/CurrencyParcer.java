package com.andriiby.model;

import com.andriiby.object.CurrencyPOJ;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Bessus on 11.08.2015.
 */
public class CurrencyParcer {

    private static final String URL_FORMAT = "http://minfin.com.ua/currency/auction/usd/sell/kiev/";


    public CurrencyPOJ getCurrencyObject() {
        CurrencyPOJ currencyPOJ = new CurrencyPOJ();
        try {
            Document doc1 = getDocument();
            Elements elements = doc1.getElementsByClass("mfm-grey-bg");
            Element element = elements.get(0);
            Elements valueElements = element.getElementsByClass("au-mid-buysell");
            currencyPOJ.setSell(getValueFromElement(valueElements.get(0)));
            currencyPOJ.setBuy(getValueFromElement(valueElements.get(1)));

            currencyPOJ.setCurrencyType("USD");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencyPOJ;
    }

    private int getValueFromElement(Element container){
        String valueBuyString = container.text();
        int index = valueBuyString.indexOf(",");
        String value = valueBuyString.substring(index-2, index+3);
        return  Integer.parseInt(value.replace(",", ""));
    }

    private Document getDocument() throws IOException {
        String searchStringFinal = String.format(URL_FORMAT);
        Connection conn = Jsoup.connect(searchStringFinal);
        conn.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0");
        conn.referrer("http://www.ukr.net");
        Document doc = conn.get();
        return doc;
    }
}
