package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ashiquechowdhury on 11/4/16.
 */
public class textViewHolder extends RecyclerView.ViewHolder{
    private TextView integerView;


    public textViewHolder(View itemView) {
        super(itemView);
        integerView = (TextView) itemView.findViewById(R.id.integerText);
    }

    public void bind(Object number){

        integerView.setText(number.toString());
    }
}
