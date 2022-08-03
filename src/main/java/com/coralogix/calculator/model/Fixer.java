package com.coralogix.calculator.model;

import java.io.Serializable;
import java.util.HashMap;

public class Fixer implements Serializable {
    private boolean success;
    private String base;
    private String date;

    public HashMap<String, String> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, String> rates) {
        this.rates = rates;
    }

    private HashMap<String,String>rates;

    @Override
    public String toString() {
        return "Fixer{" +
                "success=" + success +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
