package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import nyc.c4q.ashiquechowdhury.nowfeed.network.BuzzfeedResponse;
import nyc.c4q.ashiquechowdhury.nowfeed.network.BuzzfeedService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashiquechowdhury on 10/30/16.
 */
public class myViewHolder extends RecyclerView.ViewHolder {
    private static final String API_KEY = BuildConfig.API_KEY;

    RecyclerView mBuzzArticleRecycleView;


    public myViewHolder(View itemView) {
        super(itemView);
        mBuzzArticleRecycleView = (RecyclerView) itemView.findViewById(R.id.helen_rv);
        mBuzzArticleRecycleView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        getBuzzfeedArticle();

    }

    public void bind(Object input) {
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

                Log.d("MainActivity", "onResponse: ");
                BuzzFeedAdapter buzzFeedAdapter = new BuzzFeedAdapter(buzzresponse.getArticles());
                mBuzzArticleRecycleView.setAdapter(buzzFeedAdapter);


            }

            @Override
            public void onFailure(Call<BuzzfeedResponse> call, Throwable t) {
                Log.d("MainActivity", "onFailure: ");
            }
        });
    }
}
