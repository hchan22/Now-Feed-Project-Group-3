package nyc.c4q.ashiquechowdhury.nowfeed.moviedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Random;

import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.Movie;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.MovieList;
import nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network.MoviedbAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashiquechowdhury on 11/14/16.
 */
public class GeneralMovieActivity extends AppCompatActivity{
    RecyclerView mCardsRecyclerView;
    Random random;
    int movieYear;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardsRecyclerView = (RecyclerView) findViewById(R.id.cards_recycler_view);
        mCardsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pickRandomMovieYear();
        addPopularMovie();
    }

    private void addPopularMovie() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MoviedbAPI movieApi = retrofit.create(MoviedbAPI.class);

        Call<MovieList> call = movieApi.listPopularMovies2010();
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                MovieList popularMovies = response.body();
                List<Movie> popularMovieList = popularMovies.getResult();
                random = new Random();
                int randomMovieNumber = random.nextInt(10);
                Movie specificMovie = popularMovieList.get(randomMovieNumber);
                mCardsRecyclerView.setAdapter(new GeneralMovieCardsAdapter(specificMovie));
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }
        });
    }

    private void pickRandomMovieYear() {
        random = new Random();
        int randomYear = random.nextInt(16) + 2000;
        movieYear = randomYear;
    }
}
