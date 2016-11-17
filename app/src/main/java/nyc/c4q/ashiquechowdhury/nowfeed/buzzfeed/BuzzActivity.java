package nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import nyc.c4q.ashiquechowdhury.nowfeed.BuildConfig;
import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.network.BuzzfeedResponse;
import nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.network.BuzzfeedService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashiquechowdhury on 11/16/16.
 */
public class BuzzActivity extends AppCompatActivity{
    private static final String API_KEY = BuildConfig.API_KEY;

    private RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzz);
        getBuzzfeedArticle();
        recycle = (RecyclerView) findViewById(R.id.recyclerviewwidget);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }


    public void getBuzzfeedArticle() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BuzzfeedService service = retrofit.create(BuzzfeedService.class);
        Call<BuzzfeedResponse> call = service.getArticles("buzzfeed", "top", API_KEY);
        call.enqueue(new Callback<BuzzfeedResponse>() {
            @Override
            public void onResponse(Call<BuzzfeedResponse> call, Response<BuzzfeedResponse> response) {

                BuzzfeedResponse buzzresponse = response.body();
                BuzzFeedAdapter adapter = new BuzzFeedAdapter(buzzresponse.getArticles());
                recycle.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BuzzfeedResponse> call, Throwable t) {

            }
        });
    }

}
