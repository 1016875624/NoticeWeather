package weather.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author grayRainbow
 */
@lombok.NoArgsConstructor
@lombok.Data
public class TimeWeather {
    // 北京实况天气
    // 商业版 https://api.qweather.com/v7/weather/now?location=101010100&key=你的KEY
    // 开发版 https://devapi.qweather.com/v7/weather/now?location=101010100&key=你的KEY
    /**
     * code : 200
     * updateTime : 2020-06-30T22:00+08:00
     * fxLink : http://hfx.link/2ax1
     * now : {"obsTime":"2020-06-30T21:40+08:00","temp":"24","feelsLike":"26","icon":"101","text":"多云","wind360":"123","windDir":"东南风","windScale":"1","windSpeed":"3","humidity":"72","precip":"0.0","pressure":"1003","vis":"16","cloud":"10","dew":"21"}
     * refer : {"sources":["Weather China"],"license":["commercial license"]}
     */
    /** 5摄氏度就是变化大*/
    int degree = 5;
    public boolean isTempChange(TimeWeather timeWeather) {
        dataTemp = now.temp.subtract(timeWeather.now.temp);
        return dataTemp.abs().compareTo(new BigDecimal(degree)) > 0;
    }
    public boolean isFeelChange(TimeWeather timeWeather) {
        dataFeel = now.feelsLike.subtract(timeWeather.now.feelsLike);
        return dataFeel.abs().compareTo(new BigDecimal(degree)) > 0;
    }

    private BigDecimal dataTemp;
    private BigDecimal dataFeel;

    public boolean isRainChange() {
        return now.text.contains("雨");
    }

    private String code;
    private String updateTime;
    private String fxLink;
    private NowBean now;
    private ReferBean refer;

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class NowBean {
        /**
         * obsTime : 2020-06-30T21:40+08:00
         * temp : 24
         * feelsLike : 26
         * icon : 101
         * text : 多云
         * wind360 : 123
         * windDir : 东南风
         * windScale : 1
         * windSpeed : 3
         * humidity : 72
         * precip : 0.0
         * pressure : 1003
         * vis : 16
         * cloud : 10
         * dew : 21
         */

        private String obsTime;

        /**
         * 温度
         */
        private BigDecimal temp;
        /**
         * 体感温度
         */
        private BigDecimal feelsLike;
        private String icon;

        /**
         * 描述： 晴天 多云 小雨
         */
        private String text;
        private String wind360;
        private String windDir;
        private String windScale;
        private String windSpeed;
        private String humidity;
        private String precip;
        private String pressure;
        private String vis;
        private String cloud;
        private String dew;
    }

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class ReferBean {
        private List<String> sources;
        private List<String> license;
    }
}
