package com.andriiby.model;

import com.andriiby.object.WeatherPOJ;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

//TODO Finish class

public class WeatherParser {
    private static final String URL_FORMAT = "https://www.gismeteo.ua/weather-kyiv-4944/";


    public WeatherPOJ getWeatherObject() {
        WeatherPOJ weatherPOJ = new WeatherPOJ();
        try {
            Document doc1 = getDocument();
            Element element = doc1.getElementById("wsection wdata");
            Element section = element.getElementById("tbwdaily1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherPOJ;
    }

    protected Document getDocument() throws IOException {
        String searchStringFinal = String.format(URL_FORMAT);
        Connection conn = Jsoup.connect(searchStringFinal);
        conn.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0");
        conn.referrer("http://www.ukr.net");
        Document doc = conn.get();
        return doc;
    }
}
