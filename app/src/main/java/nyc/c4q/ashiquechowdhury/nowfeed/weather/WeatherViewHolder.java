package nyc.c4q.ashiquechowdhury.nowfeed.weather;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.weather.network.WeatherData;
import nyc.c4q.ashiquechowdhury.nowfeed.weather.network.WeatherResponse;
import nyc.c4q.ashiquechowdhury.nowfeed.weather.network.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by helenchan on 1/6/17.
 */
public class WeatherViewHolder extends RecyclerView.ViewHolder {
    TextView tempMin;
    TextView tempMax;
    TextView precipProbability;
    TextView iconTV;
    RecyclerView wRecyclerView;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        wRecyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerview_weather_card);
        wRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        tempMin = (TextView) itemView.findViewById(R.id.temp_min_tv);
        tempMax = (TextView) itemView.findViewById(R.id.temp_max_tv);
        precipProbability = (TextView) itemView.findViewById(R.id.precip_prob_tv);
        iconTV = (TextView) itemView.findViewById(R.id.icon_textview);
        fetchWeather();
    }

    public void bind(WeatherData weatherData) {
        tempMin.setText("Min" + " " + String.valueOf((int) weatherData.getTemperatureMin()) + (char) 0x00B0);
        tempMax.setText("Max" + " " + String.valueOf((int) weatherData.getTemperatureMax()) + (char) 0x00B0);
        precipProbability.setText(String.valueOf(weatherData.getPrecipProbability()));
        iconTV.setText(weatherData.getIcon());
    }

    public void fetchWeather() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.darksky.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        Call<WeatherResponse> call = service.getWeather();
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                List<WeatherData> weatherList = new ArrayList<WeatherData>();
                weatherList = response.body().getDaily().getData();
                WeatherAdapter adapter = new WeatherAdapter(weatherList);
                wRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });

    }
}

