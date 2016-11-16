package nyc.c4q.ashiquechowdhury.nowfeed.moviedb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.Movie;

/**
 * Created by ashiquechowdhury on 11/14/16.
 */
public class GeneralMovieCardsAdapter extends RecyclerView.Adapter<GeneralMovieCardViewHolder> {
    List<Movie> myMovies;


    public GeneralMovieCardsAdapter(Movie specificMovie) {
        myMovies = new ArrayList<>();
        myMovies.add(specificMovie);
    }

    @Override
    public GeneralMovieCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        childView = inflater.inflate(R.layout.movie_card_row, parent, false);
        return new GeneralMovieCardViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(GeneralMovieCardViewHolder holder, int position) {
        holder.bind(myMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return myMovies.size();
    }
}
