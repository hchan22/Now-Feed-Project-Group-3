package nyc.c4q.ashiquechowdhury.nowfeed.moviedb;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.Movie;

/**
 * Created by ashiquechowdhury on 11/14/16.
 */
public class GeneralMovieCardViewHolder extends RecyclerView.ViewHolder{
    ImageView movieImage;
    TextView yearOfMovie;
    TextView movieTitleView;
    public static final String YEAR = "nyc.c4q.ashiquechowdhury.YEAR";

    public GeneralMovieCardViewHolder(View itemView) {
        super(itemView);
        movieTitleView = (TextView) itemView.findViewById(R.id.movie_row_title);
        movieImage = (ImageView) itemView.findViewById(R.id.movie_imageView);
        yearOfMovie = (TextView) itemView.findViewById(R.id.movie_year_textView);
    }

    public void bind(Movie movie) {
        String year = movie.getRelease_date().substring(0,4);
        String movieTitle = movie.getTitle();
        movieTitleView.setText(movieTitle);
        yearOfMovie.setText(" " + year + " Popular Hit");
        Picasso.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w300" + movie.getPoster_path()).fit().into(movieImage);
        itemView.setOnClickListener(movieClickListener(year));
    }

    private View.OnClickListener movieClickListener(final String year) {
        return new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MovieActivity.class);
                intent.putExtra(YEAR, year);
                view.getContext().startActivity(intent);
            }
        };
    }
}