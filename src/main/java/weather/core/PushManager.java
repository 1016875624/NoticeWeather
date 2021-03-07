package weather.core;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import weather.dto.TimeWeather;

import java.io.IOException;

/**
 * @author grayRainbow
 */
public class PushManager {
    OkHttpClient client = new OkHttpClient();
    PrintManager printManager = new PrintManager();
    public void pushServerJiang(TimeWeather timeWeather, String key) throws IOException {
        final String url = "https://sc.ftqq.com/%s.send";
        String format = String.format(url, key);
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("text", "气温变化提醒");
        formBody.add("desp", printManager.getTemplate(timeWeather));
        Request request = new Request.Builder().url(format).post(formBody.build()).build();
        Response response = client.newCall(request).execute();
        if (response.code() != 200) {
            throw new IOException("推送失败");
        }
    }
}
