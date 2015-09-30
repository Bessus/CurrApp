package com.andriiby.model;

/**
 * Created by Bessus on 15.09.2015.
 */
public class EURParser extends CurrencyParser {

    private static final String URL_FORMAT = "http://minfin.com.ua/currency/auction/eur/sell/kiev/";
    private static final String CURRENCY_CODE = "EUR";

    @Override
    protected String getURLFormat() {
        return  URL_FORMAT;
    }

    @Override
    protected String getCurrencyCode() {
        return CURRENCY_CODE;
    }
}
