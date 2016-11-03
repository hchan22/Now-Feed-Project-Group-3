package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ashiquechowdhury on 10/30/16.
 */
public class myViewHolder extends RecyclerView.ViewHolder {

    TextView tv;

    public myViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.cardview_text);
    }

    public void bind(String input){
        tv.setText(input);
    }
}
