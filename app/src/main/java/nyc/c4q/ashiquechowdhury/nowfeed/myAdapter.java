package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ashiquechowdhury on 10/30/16.
 */
public class myAdapter extends RecyclerView.Adapter {
    private final static int NUMBER = 1, TEXT = 2;
    List<Object> myList;

    public myAdapter(List aList){
        myList = aList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if(viewType == 1){
            childView = inflater.inflate(R.layout.cardview, parent, false);
            return new myViewHolder(childView);
        }
        else if(viewType ==2){
            childView = inflater.inflate(R.layout.integer_layout, parent,false);
            return new textViewHolder(childView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position){
        if(myList.get(position) instanceof String){
            return 1;
        }
        if(myList.get(position) instanceof Integer){
            return 2;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
