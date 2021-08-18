package org.example.yandexweatherapi.model;

import com.google.gson.annotations.SerializedName;

public class Fact {
    private String temp;
    private String condition;
    @SerializedName("pressure_mm")
    private String pressure;
    private String humidity;
    @SerializedName("wind_speed")
    private String windSpeed;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

}
