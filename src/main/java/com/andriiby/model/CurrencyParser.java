package com.andriiby.model;

import com.andriiby.object.CurrencyPOJ;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Bessus on 15.09.2015.
 */
public abstract class CurrencyParser {

    public CurrencyPOJ getCurrencyObject() {
        CurrencyPOJ currencyPOJ = new CurrencyPOJ();
        try {
            Document doc1 = getDocument();
            Elements elements = doc1.getElementsByClass("mfm-grey-bg");
            Element element = elements.get(0);
            Elements valueElements = element.getElementsByClass("au-mid-buysell");
            currencyPOJ.setSell(getCurrencyValueFromElement(valueElements.get(0)));
            currencyPOJ.setBuy(getCurrencyValueFromElement(valueElements.get(1)));

            Elements propElements = element.getElementsByClass("au-pbar");

            currencyPOJ.setDemand(getCurrencyQuantityFromElement(propElements.get(2)));
            currencyPOJ.setProposition(getCurrencyQuantityFromElement(propElements.get(3)));


            currencyPOJ.setCurrencyType(getCurrencyCode());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencyPOJ;
    }

    protected int getCurrencyValueFromElement(Element container){
        String valueBuyString = container.text();
        int index = valueBuyString.indexOf(",");
        String value = valueBuyString.substring(index-2, index+3);
        return  Integer.parseInt(value.replace(",", "").replace(" ", ""));
    }

    private String getCurrencyQuantityFromElement(Element container){
        String valueBuyString = container.text();
        String [] resultArray = valueBuyString.split("<span class=\"au-pbar-tooltip-grey\"><strong>");
        String preResult = resultArray[0];
        int index = preResult.indexOf(" ");
        String result = preResult.substring(index+1, getEndIndex(preResult));
        return result;
    }

    private Document getDocument() throws IOException {
        String searchStringFinal = String.format(getURLFormat());
        Connection conn = Jsoup.connect(searchStringFinal);
        conn.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0");
        conn.referrer("http://www.ukr.net");
        return conn.get();
    }

    private int getEndIndex(String string){
        int result = -1;
        char [] array = string.toCharArray();
        for (int i = 9; i<array.length; i++){
            if (array[i] != 32 && (array[i]<48 || array[i]>57)){
                return i;
            }
        }
        return result;
    }

    protected abstract String getURLFormat();

    protected abstract String getCurrencyCode();

}
