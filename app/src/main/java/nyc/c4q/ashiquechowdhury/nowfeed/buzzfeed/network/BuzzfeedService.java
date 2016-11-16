package nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by helenchan on 11/12/16.
 */

public interface BuzzfeedService {
    @GET("v1/articles")
    Call<BuzzfeedResponse> getArticles(@Query("source") String source,
                                       @Query("sortBy") String sortBy,
                                       @Query("apiKey") String apiKey );

}
