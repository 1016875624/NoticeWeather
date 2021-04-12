package weather.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author grayRainbow
 */
public class PathManager {
    public String getTimeWeatherPath() {
        return "TimeWeather.json";
    }

    public String getDateWeatherPath() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return String.format("TimeWeather%s.json", date);
    }

    public String getYesterdayWeatherPath() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String date = yesterday.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return String.format("TimeWeather%s.json", date);
    }

}
