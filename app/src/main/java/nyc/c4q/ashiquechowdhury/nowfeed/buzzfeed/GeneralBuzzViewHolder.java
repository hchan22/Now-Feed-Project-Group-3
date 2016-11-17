package nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import nyc.c4q.ashiquechowdhury.nowfeed.BuildConfig;
import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.network.BuzzfeedResponse;
import nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.network.BuzzfeedService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GeneralBuzzViewHolder extends RecyclerView.ViewHolder {
    private static final String API_KEY = BuildConfig.API_KEY;
    private RecyclerView recycle;

    public GeneralBuzzViewHolder(View itemView) {
        super(itemView);
        recycle = (RecyclerView) itemView.findViewById(R.id.buzz_card_rview);
        recycle.setLayoutManager(new GridLayoutManager(itemView.getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        getBuzzfeedArticle();
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

    public void bind() {

    }
}
