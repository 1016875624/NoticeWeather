package weather.core;

/**
 * @author grayRainbow
 */
public class ParameterManager {
    String baoAn = "101280605";
    String nanShan = "101280604";
    public String getWeatherKey() {
        return System.getenv("WeatherKey");
    }
    public String getPushKey() {
        return System.getenv("PushKey");
    }

    public String getLocation() {
        return nanShan;
    }

    public String getBaoAnLocation() {
        return baoAn;
    }

    public String getNanShanLocation() {
        return nanShan;
    }
}
