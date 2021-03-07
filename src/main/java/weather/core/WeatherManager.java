package weather.core;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import weather.dto.TimeWeather;

import java.io.IOException;
import java.util.Objects;

/**
 * @author grayRainbow
 */
public class WeatherManager {
    OkHttpClient client = new OkHttpClient();
    public TimeWeather getNowWeather(String location, String key) throws IOException {
        final String url = "https://devapi.qweather.com/v7/weather/now?location=%s&key=%s";
        String format = String.format(url, location, key);
        Request request = new Request.Builder().url(format).get().build();
        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        return gson.fromJson(Objects.requireNonNull(response.body()).string(), TimeWeather.class);
    }
}
