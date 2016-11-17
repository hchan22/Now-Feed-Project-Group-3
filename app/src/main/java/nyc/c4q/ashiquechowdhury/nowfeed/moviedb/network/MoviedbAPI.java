package nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashiquechowdhury on 11/13/16.
 */
public interface MoviedbAPI {
    @GET("3/discover/movie?api_key=75142b6ae9b9f1b3d247b1af9a6131e9")
    Call<MovieList> listMovies();

    @GET("3/discover/movie?primary_release_year=2010&sort_by=vote_average.desc&api_key=75142b6ae9b9f1b3d247b1af9a6131e9")
    Call<MovieList> listPopularMovies(@Query("primary_release_year") String year,
                                      @Query("sort_by") String sort,
                                      @Query("api_key") String apiKey);
}
