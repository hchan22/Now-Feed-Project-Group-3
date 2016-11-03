package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ashiquechowdhury on 10/30/16.
 */
public class myAdapter extends RecyclerView.Adapter<myViewHolder> {
    List<String> myList = Arrays.asList("ridita" , "helen" , "ashique");

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new myViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.bind(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
