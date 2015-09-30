package com.andriiby.model;

/**
 * Created by Bessus on 15.09.2015.
 */
public class RUBParser extends CurrencyParser {

    private static final String URL_FORMAT = "http://minfin.com.ua/currency/auction/rub/sell/kiev/";
    private static final String CURRENCY_CODE = "RUB";

    @Override
    protected String getURLFormat() {
        return  URL_FORMAT;
    }

    @Override
    protected String getCurrencyCode() {
        return CURRENCY_CODE;
    }
}
