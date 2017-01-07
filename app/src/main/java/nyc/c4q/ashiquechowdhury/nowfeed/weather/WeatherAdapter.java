package nyc.c4q.ashiquechowdhury.nowfeed.weather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.weather.network.WeatherData;

/**
 * Created by helenchan on 1/6/17.
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    List<WeatherData> weatherList = new ArrayList<>();

    public WeatherAdapter(List<WeatherData> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_itemview, parent, false);
        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        WeatherData currentlyWeather = weatherList.get(position);
        holder.bind(currentlyWeather);

    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public void setData(List<Object> objectList){
        objectList.clear();
        objectList.addAll(objectList);
        notifyDataSetChanged();
    }
}