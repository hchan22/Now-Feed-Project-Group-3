package nyc.c4q.ashiquechowdhury.nowfeed.moviedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.MovieList;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.MoviedbAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashiquechowdhury on 11/13/16.
 */
public class MovieActivity extends AppCompatActivity {
    RecyclerView movieRecyclerView;
    List<MovieDescriptions> myMoviesss;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        myMoviesss = new ArrayList<>();
        movieRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        callMovieRetrofit();
    }

    private void callMovieRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/").addConverterFactory(GsonConverterFactory.create()).build();
        MoviedbAPI MovieAPI = retrofit.create(MoviedbAPI.class);

        Call<MovieList> call = MovieAPI.listMovies();
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                MovieList myMovieList= response.body();
                for (int i = 0; i < myMovieList.getResult().size(); i++) {
                    myMoviesss.add(new MovieDescriptions(myMovieList.getResult().get(i).getOverview(), myMovieList.getResult().get(i).getPoster_path()));
                }
                movieRecyclerView.setAdapter(new MovieAdapter(myMoviesss));
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
            }
        });
    }


}
