package nyc.c4q.ashiquechowdhury.nowfeed.weather.network;

import nyc.c4q.ashiquechowdhury.nowfeed.weather.network.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by helenchan on 1/6/17.
 */

public interface WeatherService {

    @GET("forecast/94ef1917e6c96b5a7055dc08a9d9bb0c/37.8267,-122.4233")
    Call<WeatherResponse> getWeather();
}
