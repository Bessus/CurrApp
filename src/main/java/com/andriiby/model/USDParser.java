package com.andriiby.model;

/**
 * Created by Bessus on 11.08.2015.
 */
public class USDParser extends CurrencyParser {

    private static final String URL_FORMAT = "http://minfin.com.ua/currency/auction/usd/sell/kiev/";
    private static final String CURRENCY_CODE = "USD";

    @Override
    protected String getURLFormat() {
        return  URL_FORMAT;
    }

    @Override
    protected String getCurrencyCode() {
        return CURRENCY_CODE;
    }
}
