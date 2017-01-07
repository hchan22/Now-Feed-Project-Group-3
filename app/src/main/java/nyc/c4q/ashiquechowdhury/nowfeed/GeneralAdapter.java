package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.GeneralBuzzViewHolder;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.GeneralMovieCardViewHolder;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.Movie;
import nyc.c4q.ashiquechowdhury.nowfeed.weather.WeatherViewHolder;
import nyc.c4q.ashiquechowdhury.nowfeed.weather.network.WeatherData;

/**
 * Created by ashiquechowdhury on 11/14/16.
 */
public class GeneralAdapter extends RecyclerView.Adapter {
    private static final int MOVIE = 1;
    private static final int BUZZ = 2;
    private static final int WEATHER = 3;

    List<Object> myCards;

    public GeneralAdapter(List<Object> myList) {
        myCards = myList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == BUZZ) {
            childView = inflater.inflate(R.layout.buzz_card_row, parent, false);
            return new GeneralBuzzViewHolder(childView);
        } else if (viewType == MOVIE) {
            childView = inflater.inflate(R.layout.movie_card_row, parent, false);
            return new GeneralMovieCardViewHolder(childView);
        } else if (viewType == WEATHER){
            childView = inflater.inflate(R.layout.weather_card_row, parent, false);
            return new WeatherViewHolder(childView);
        }
        childView = inflater.inflate(R.layout.movie_card_row, parent, false);
        return new GeneralBuzzViewHolder(childView);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case BUZZ:
                ((GeneralBuzzViewHolder) holder).bind();
                break;
            case MOVIE:
                ((GeneralMovieCardViewHolder) holder).bind((Movie) myCards.get(position % (myCards.size())));
                break;
            case WEATHER:
                ((WeatherViewHolder) holder).bind((WeatherData) myCards.get(position % (myCards.size())));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 20000000;
    }

    @Override
    public int getItemViewType(int position) {
        if (myCards.get(position % (myCards.size())) instanceof Movie) {
            return MOVIE;
        } else if (myCards.get(position % (myCards.size())) instanceof String) {
            return BUZZ;
        } else {
            return WEATHER;
        }
    }

}
