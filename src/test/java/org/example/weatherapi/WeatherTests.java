package org.example.weatherapi;

import com.google.gson.Gson;
import org.example.yandexweatherapi.OkHttpBuilder;
import org.example.yandexweatherapi.model.Forecast;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class WeatherTests {

    @Test(description = "Getting info about the weather in different cities ",
            dataProviderClass = TestData.class, dataProvider = "getWeather")
    public void getWeatherInfo(String lat, String lon, String lan, String limit, String hours, String extra) throws IOException {
        OkHttpBuilder okHttpBuilder = new OkHttpBuilder();
        Response response = okHttpBuilder.getResponse(lat, lon, lan, limit, hours, extra);
        Assert.assertEquals(response.code(), 200, "Wrong Response code");
        Assert.assertNotNull(response.body(), "Response has no body. Try another Request");
        String jsonText = response.body().string();
        Gson gson = new Gson();
        Forecast forecast = gson.fromJson(jsonText, Forecast.class);
        Assert.assertEquals(forecast.getInfo().getLat(), lat, "Info from Response doesn't match with your Request because of wrong Latitude");
        Assert.assertEquals(forecast.getInfo().getLon(), lon, "Info from Response doesn't match with your Request because of wrong Longitude");
        printOut(forecast);
    }

    @Test(description = "Getting error (status 404) because of wrong geolocation ",
            dataProviderClass = TestData.class, dataProvider = "getErrorNotFound")
    public void getErrorNotFoundInfo(String lat, String lon, String lan, String limit, String hours, String extra) throws IOException {
        OkHttpBuilder okHttpBuilder = new OkHttpBuilder();
        Response response = okHttpBuilder.getResponse(lat, lon, lan, limit, hours, extra);
        Assert.assertEquals(response.code(), 404, "Wrong Response code");
        Assert.assertNotNull(response.body(), "Response has no body. Try another Request");
        System.out.println("Response is: " + response.code() + "  " + response.body().string());
    }

    @Test(description = "Getting error (status 400) because of wrong query parameters ",
            dataProviderClass = TestData.class, dataProvider = "getErrorBadRequest")
    public void getErrorBadRequestInfo(String lat, String lon, String lan, String limit, String hours, String extra) throws IOException {
        OkHttpBuilder okHttpBuilder = new OkHttpBuilder();
        Response response = okHttpBuilder.getResponse(lat, lon, lan, limit, hours, extra);
        Assert.assertEquals(response.code(), 400, "Wrong Response code");
        Assert.assertNotNull(response.body(), "Response has no body. Try another Request");
        System.out.println("Response is: " + response.code() + "  " + response.body().string());
    }

    private void printOut(Forecast forecast) {
        System.out.println("Current weather in " + forecast.getGeoObject().getLocality().getName() + ":\n"
                + "Date: " + forecast.getDate().substring(0, 10) + "\n"
                + "Temperature (C): " + forecast.getFact().getTemp() + "\n"
                + "Condition: " + forecast.getFact().getCondition() + "\n"
                + "Pressure (mm): " + forecast.getFact().getPressure() + "\n"
                + "Humidity (%): " + forecast.getFact().getHumidity() + "\n"
                + "Wind Speed (m/s): " + forecast.getFact().getWindSpeed() + "\n");
    }
}
