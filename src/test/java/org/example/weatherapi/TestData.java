package org.example.weatherapi;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider
    public static Object[][] getWeather() {
        return new Object[][]{
                {"55.818532", "37.440297", "en_US", "3", "false", "false"},
                {"55.798989", "49.10635", "ru_RU", "2", "false", "true"},
                {"47.822872", "35.161391", "uk_UA", "1", "true", "false"},
                {"53.113083", "26.01446", "be_BY", "3", "false", "true"},
                {"47.786178", "67.702774", "kk_KZ", "1", "false", "false"},
                {"36.776742", "31.400092", "tr_TR", "2", "true", "true"},
        };
    }

    @DataProvider
    public static Object[][] getErrorNotFound() {
        return new Object[][]{
                {"200", "250", "tr_TR", "7", "true", "true"}
        };
    }

    @DataProvider
    public static Object[][] getErrorBadRequest() {
        return new Object[][]{
                {"47.822872", "35.161391", "en_US", "1", "moscow", "false"}
        };
    }

}
