package org.example.yandexweatherapi.model;

import com.google.gson.annotations.SerializedName;

public class Forecast {
    @SerializedName("now_dt")
    private String date;
    private Info info;
    @SerializedName("geo_object")
    private GeoObject geoObject;
    private Fact fact;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public GeoObject getGeoObject() {
        return geoObject;
    }

    public void setGeoObject(GeoObject geoObject) {
        this.geoObject = geoObject;
    }

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }
}
