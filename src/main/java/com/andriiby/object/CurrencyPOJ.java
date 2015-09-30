package com.andriiby.object;

/**
 * Created by Bessus on 11.08.2015.
 */
public class CurrencyPOJ {
    private int buy;
    private int sell;
    private String proposition;
    private String demand;
    private String currencyType;

    public CurrencyPOJ() {
    }

    public int getBuy() {
        return buy;
    }

    public int getSell() {
        return sell;
    }

    public String getProposition() {
        return proposition;
    }

    public String getDemand() {
        return demand;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return "CurrencyPOJ{" +
                "buy=" + buy +
                ", sell=" + sell +
                ", proposition='" + proposition + '\'' +
                ", demand='" + demand + '\'' +
                ", currencyType='" + currencyType + '\'' +
                '}';
    }
}
