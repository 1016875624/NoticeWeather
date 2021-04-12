package weather.service;

import weather.core.*;
import weather.dto.TimeWeather;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author grayRainbow
 */
public class WeatherChangeNotice {
    WeatherManager weatherManager = new WeatherManager();
    StoreManager storeManager = new StoreManager();
    ParameterManager parameterManager = new ParameterManager();
    NoticeManager noticeManager = new NoticeManager();
    PushManager pushManager = new PushManager();
    PathManager pathManager = new PathManager();
    public void noticeWeather() {
        TimeWeather weather = null;
        boolean need = true;
        try {
            weather = storeManager.loadTimeWeather();
            TimeWeather nowWeather = getNowWeather();
            if (weather != null) {
                need = noticeManager.needNotice(weather, nowWeather);
            }
            if (need) {
                pushManager.pushServerJiang(nowWeather, noticeManager.getNoticeTitle(weather, nowWeather), parameterManager.getPushKey());
            }
            storeManager.storeTimeWeather(nowWeather);
            if (storeManager.loadTimeWeather(pathManager.getDateWeatherPath()) == null) {
                storeManager.storeTimeWeather(pathManager.getDateWeatherPath(), nowWeather);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TimeWeather getNowWeather() {
        String location = parameterManager.getLocation();
        String key = parameterManager.getWeatherKey();
        try {
            TimeWeather nowWeather = weatherManager.getNowWeather(location, key);
            return nowWeather;
        } catch (IOException e) {
            try {
                return weatherManager.getNowWeather(location, key);
            } catch (IOException ioException) {
                throw new RuntimeException("获取天气失败");
            }
        }
    }
}
