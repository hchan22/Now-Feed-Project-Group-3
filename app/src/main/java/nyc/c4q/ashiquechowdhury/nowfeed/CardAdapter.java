package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.network.Article;

/**
 * Created by ashiquechowdhury on 10/30/16.
 */
public class CardAdapter extends RecyclerView.Adapter {
    private final static int BUZZ = 1, TEXT = 2;

    List<Object> listOfData = new ArrayList<>();;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case BUZZ:
                viewHolder = new BuzzArticleHolder((parent));
                break;
        }
        return viewHolder;
    }

//


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch(viewHolder.getItemViewType()){
            case BUZZ:
                BuzzArticleHolder buzzfeedViewHolder = (BuzzArticleHolder) viewHolder;
                buzzfeedViewHolder.bind(listOfData.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (listOfData.get(position) instanceof Article) {
            return BUZZ;
        }
        if (listOfData.get(position) instanceof Integer) {
            return TEXT;
        }

        return -1;
    }

    public void addToList(Object data) {
        listOfData.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listOfData.size();
    }
}
