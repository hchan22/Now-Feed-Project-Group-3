package nyc.c4q.ashiquechowdhury.nowfeed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class GeneralCardActivity extends AppCompatActivity{
    RecyclerView mCardsRecyclerView;
    Random random;
    List<Object> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_cards);
        myList = new ArrayList<>();
        myList.add(new String("BuzzFeed"));

//        mCardsRecyclerView = (RecyclerView) findViewById(R.id.cards_recycler_view);
//        mCardsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        String movieYear = pickRandomMovieYear();
        addPopularMovie(movieYear);

        mCardsRecyclerView = (RecyclerView) findViewById(R.id.cards_recycler_view);
        mCardsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addPopularMovie(String movieYear) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MoviedbAPI movieApi = retrofit.create(MoviedbAPI.class);

        Call<MovieList> call = movieApi.listPopularMovies(movieYear, "vote_average.desc","75142b6ae9b9f1b3d247b1af9a6131e9");
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                MovieList popularMovies = response.body();
                List<Movie> popularMovieList = popularMovies.getResult();
                random = new Random();
                int randomMovieNumber = random.nextInt(10);
                Movie specificMovie = popularMovieList.get(randomMovieNumber);

                myList.add(specificMovie);
                mCardsRecyclerView.setAdapter(new GeneralAdapter(myList));
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }
        });
    }

    private String pickRandomMovieYear() {
        random = new Random();
        return String.valueOf(random.nextInt(16) + 2000);
    }
}
