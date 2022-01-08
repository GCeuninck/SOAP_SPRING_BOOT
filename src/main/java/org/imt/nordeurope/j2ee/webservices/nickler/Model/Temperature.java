package org.imt.nordeurope.j2ee.webservices.nickler.Model;

import java.util.Date;

public class Temperature {
    private Integer temperature;
    private String country;
    private Date date;

    public Temperature(Integer temperature, String country, Date date) {
        this.temperature = temperature;
        this.country = country;
        this.date = date;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
