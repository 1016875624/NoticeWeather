package weather.core;

import weather.dto.TimeWeather;

/**
 * @author grayRainbow
 */
public class NoticeManager {
    public boolean needNotice(TimeWeather before, TimeWeather now) {
        return now.isRainChange() || now.isFeelChange(before) || now.isTempChange(before);
    }

    public String getNoticeTitle(TimeWeather before, TimeWeather now) {
        if (before == null) {
            return "首次提醒";
        }
        if (now.isRainChange()) {
            return "下雨了";
        }
        // 体感温度变化
        if (now.isFeelChange(before)) {
            return "体感温度变化：" + now.getDataFeel() + " 度";
        }
        // 体感温度变化
        if (now.isTempChange(before)) {
            return "温度变化：" + now.getDataTemp();
        }
        return "";
    }
}
