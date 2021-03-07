package runner;

import weather.core.WeatherManager;
import weather.service.WeatherChangeNotice;

/**
 * @author grayRainbow
 */
public class GetNowWeatherRunner {
    WeatherManager weatherManager = new WeatherManager();
    WeatherChangeNotice weatherChangeNotice = new WeatherChangeNotice();
    public static void main(String[] args) {
        new GetNowWeatherRunner().run();
    }
    public void run() {
        weatherChangeNotice.noticeWeather();
    }
}
