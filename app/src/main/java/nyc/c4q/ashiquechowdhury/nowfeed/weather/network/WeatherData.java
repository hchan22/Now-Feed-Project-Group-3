package nyc.c4q.ashiquechowdhury.nowfeed.weather.network;

/**
 * Created by helenchan on 1/6/17.
 */
public class WeatherData {
    private String icon;
    private double temperatureMin;
    private double temperatureMax;
    private double precipProbability;

    public String getIcon() {
        return icon;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }
}
