package nyc.c4q.ashiquechowdhury.nowfeed.moviedb;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.ashiquechowdhury.nowfeed.R;

/**
 * Created by ashiquechowdhury on 11/13/16.
 */
public class MovieYearViewHolder extends RecyclerView.ViewHolder{
    ImageView movieImage;
    TextView movieDescription;

    public MovieYearViewHolder(View itemView) {
        super(itemView);
        movieImage = (ImageView) itemView.findViewById(R.id.myMovieImageView);
        movieDescription = (TextView) itemView.findViewById(R.id.movie_decription_textView);
    }


    public void bind(MovieDescriptions movieDescriptions) {
        movieDescription.setText(movieDescriptions.getDescription());
        Picasso.with(itemView.getContext()).load("http://image.tmdb.org/t/p/w300" + movieDescriptions.getImagePath()).fit().into(movieImage);
    }
}
