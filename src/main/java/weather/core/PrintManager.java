package weather.core;

import weather.dto.TimeWeather;

/**
 * @author grayRainbow
 */
public class PrintManager {
    String template = "温度:%.2f <br/> 体感温度:%.2f <br/> 描述:%s <br/> 温度变化:%.2f <br/> 体感温度变化:%.2f<br/>";

    public String getTemplate(TimeWeather weather) {
        return String.format(template, weather.getNow().getTemp(),
                weather.getNow().getFeelsLike(),
                weather.getNow().getText(),
                weather.getDataTemp(), weather.getDataFeel());
    }
}
