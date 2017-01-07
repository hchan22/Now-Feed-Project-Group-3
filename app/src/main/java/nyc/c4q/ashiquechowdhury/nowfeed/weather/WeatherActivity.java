package nyc.c4q.ashiquechowdhury.nowfeed.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.weather.network.Currently;
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

public class WeatherActivity extends AppCompatActivity {
    List<WeatherData> weatherList;
    RecyclerView recyclerView;
    WeatherAdapter adapter;
    TextView currentTemp;
    TextView summary;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_weather_widget);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new WeatherAdapter(weatherList));
    }

    @Override
    public void onStart() {
        super.onStart();
        currentTemp = (TextView) findViewById(R.id.currenttemp_tv);
        summary = (TextView) findViewById(R.id.summary_tv);
        fetchWeather();
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
                Currently current = response.body().getCurrently();
                currentTemp.setText(String.valueOf((int) current.getTemperature()) + (char) 0x00B0);
                summary.setText(current.getSummary());
                weatherList = response.body().getDaily().getData();
                adapter = new WeatherAdapter(weatherList);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });

    }
}
