package org.example.yandexweatherapi;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OkHttpBuilder {

    public Response getResponse(String lat, String lon, String lan, String limit, String hours, String extra) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Map<String, String> qparams = new HashMap<>();
        qparams.put("lat", lat);
        qparams.put("lon", lon);
        qparams.put("lang", lan);
        qparams.put("limit", limit);
        qparams.put("hours", hours);
        qparams.put("extra", extra);

        Assert.assertNotNull(Constants.URL, "URL is null. You need to fix it");
        HttpUrl.Builder httpBuilder = HttpUrl.parse(Constants.URL).newBuilder();
        for (Map.Entry<String, String> param : qparams.entrySet()) {
            httpBuilder.addQueryParameter(param.getKey(), param.getValue());
        }

        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .method("GET", null)
                .addHeader("X-Yandex-API-Key", Constants.API_KEY)
                .build();
        Response response = null;
        {
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                Assert.fail("Failed Request execution. Try another one", e);
            }
            return response;
        }
    }
}

