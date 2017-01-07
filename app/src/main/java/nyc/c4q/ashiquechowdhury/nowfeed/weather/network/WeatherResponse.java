package nyc.c4q.ashiquechowdhury.nowfeed.weather.network;

/**
 * Created by helenchan on 1/6/17.
 */
public class WeatherResponse {
    private String timezone;
    private Currently currently;
    private Daily daily;

    public String getTimezone() {
        return timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public Daily getDaily() {
        return daily;
    }
}
