package nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.ashiquechowdhury.nowfeed.R;
import nyc.c4q.ashiquechowdhury.nowfeed.buzzfeed.network.Article;

/**
 * Created by helenchan on 11/12/16.
 */

public class BuzzArticleHolder extends RecyclerView.ViewHolder {

    private View mView;
    private TextView titleText;
    private TextView textView;
    private ImageView imageview;
    private RecyclerView recycle;
    Context context;



    public BuzzArticleHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        titleText = (TextView) mView.findViewById(R.id.title_text);
        textView = (TextView) mView.findViewById(R.id.description_text);
        imageview = (ImageView) mView.findViewById(R.id.image_view);

    }

    public void bind(Article article) {
        titleText.setText(article.getTitle());
        textView.setText(article.getDescription());
        Picasso.with(context)
                .load(article.getUrlToImage())
                .into(imageview);

    }


    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.buzzfeed_layout, parent, false);
    }


}
