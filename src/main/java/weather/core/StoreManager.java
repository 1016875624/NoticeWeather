package weather.core;

import com.google.gson.Gson;
import weather.dto.TimeWeather;

import java.io.*;

/**
 * @author grayRainbow
 */
public class StoreManager {
    PathManager pathManager = new PathManager();
    public TimeWeather loadTimeWeather(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        if (!new File(path).exists()) {
            return null;
        }
        return gson.fromJson(new FileReader(path), TimeWeather.class);
    }

    public TimeWeather loadTimeWeather() throws FileNotFoundException {
        return loadTimeWeather(pathManager.getTimeWeatherPath());
    }

    public void storeTimeWeather(String path, TimeWeather weather) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(weather);
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(json);
            fileWriter.flush();
        }
        try (FileWriter fileWriter = new FileWriter("update.txt")) {
            fileWriter.write("" + System.currentTimeMillis());
            fileWriter.flush();
        }
    }

    public void storeTimeWeather(TimeWeather weather) throws IOException {
        storeTimeWeather(pathManager.getTimeWeatherPath(), weather);
    }
}
