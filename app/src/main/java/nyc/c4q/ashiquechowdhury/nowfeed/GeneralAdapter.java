package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.GeneralBuzzViewHolder;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.Movie;

/**
 * Created by ashiquechowdhury on 11/14/16.
 */
public class GeneralAdapter extends RecyclerView.Adapter {
    List<Movie> myMovies;
    List<String> myArticles;

    public GeneralAdapter(String buzz){
        myArticles = new ArrayList<>();
        myArticles.add(buzz);
    }

    public GeneralAdapter(Movie specificMovie) {
        myMovies = new ArrayList<>();
        myMovies.add(specificMovie);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View childView;
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        childView = inflater.inflate(R.layout.movie_card_row, parent, false);
//        return new GeneralMovieCardViewHolder(childView);

        View childView;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        childView = inflater.inflate(R.layout.buzz_card_row, parent, false);
        return new GeneralBuzzViewHolder(childView);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ((GeneralBuzzViewHolder) holder).bind(myArticles.get(position));
        ((GeneralBuzzViewHolder) holder).bind();
    }

    @Override
    public int getItemCount() {
        return myArticles.size();
    }
}
