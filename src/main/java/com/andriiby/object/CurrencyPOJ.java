package com.andriiby.object;

/**
 * Created by Bessus on 11.08.2015.
 */
public class CurrencyPOJ {
    private int buy;
    private int sell;
    private String currencyType;

    public CurrencyPOJ() {
    }

    public CurrencyPOJ(int buy, String currencyType, int sell) {
        this.buy = buy;
        this.currencyType = currencyType;
        this.sell = sell;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public String toString() {
        return "CurrencyPOJ{" +
                "buy=" + buy +
                ", sell=" + sell +
                ", currencyType='" + currencyType + '\'' +
                '}';
    }
}
