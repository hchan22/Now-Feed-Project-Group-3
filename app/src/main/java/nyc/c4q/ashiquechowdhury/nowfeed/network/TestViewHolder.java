package nyc.c4q.ashiquechowdhury.nowfeed.network;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.ashiquechowdhury.nowfeed.BuildConfig;
import nyc.c4q.ashiquechowdhury.nowfeed.BuzzFeedAdapter;
import nyc.c4q.ashiquechowdhury.nowfeed.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by helenchan on 11/12/16.
 */

public class TestViewHolder extends RecyclerView.ViewHolder {
    private static final String API_KEY = BuildConfig.API_KEY;
    private final BuzzFeedAdapter mAdapter;
    private final View mItemView;
    private RecyclerView recycle;
    private Context context;

    public TestViewHolder(View itemView) {
        super(inflateView(itemView));
        mItemView = inflateView(itemView);
        getBuzzfeedArticle();
        context= mItemView.getContext();
        recycle = (RecyclerView) mItemView.findViewById(R.id.helen_rv);
        recycle.setLayoutManager(new LinearLayoutManager(context));
        mAdapter = new BuzzFeedAdapter(context);
        recycle.setAdapter(mAdapter);

    }

    private static View inflateView(View parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.buzz_card_view, (ViewGroup) parent, false);
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




                mAdapter.addArticleList(buzzresponse.getArticles());
            }

            @Override
            public void onFailure(Call<BuzzfeedResponse> call, Throwable t) {
            }
        });
    }
}
