package nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.network.Article;

/**
 * Created by helenchan on 11/12/16.
 */
public class BuzzFeedAdapter extends RecyclerView.Adapter {
    Context context;
    private List<Article> articles = new ArrayList<>();

    public BuzzFeedAdapter() {

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BuzzArticleHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BuzzArticleHolder addArticles = (BuzzArticleHolder) holder;
        Article response = articles.get(position);
        addArticles.bind(response);
    }

    public void addArticleList(List<Article> newArticles){
        articles.clear();
        articles.addAll(newArticles);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
