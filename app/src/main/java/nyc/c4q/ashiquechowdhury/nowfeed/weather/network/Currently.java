package nyc.c4q.ashiquechowdhury.nowfeed.weather.network;

/**
 * Created by helenchan on 1/6/17.
 */
public class Currently {
    private long time;
    private String summary;
    private String icon;
    private double temperature;
    private double apparentTemperature;
    private double windSpeed;

    public long getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}
