package weather.core;

import weather.dto.TimeWeather;

/**
 * @author grayRainbow
 */
public class NoticeManager {
    public boolean needNotice(TimeWeather before, TimeWeather now) {
        return now.isRainChange() || now.isFeelChange(before) || now.isTempChange(before);
    }

}
