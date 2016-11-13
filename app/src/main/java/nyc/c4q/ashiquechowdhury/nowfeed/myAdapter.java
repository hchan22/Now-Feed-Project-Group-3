package nyc.c4q.ashiquechowdhury.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.ashiquechowdhury.nowfeed.network.TestViewHolder;

/**
 * Created by ashiquechowdhury on 10/30/16.
 */
public class myAdapter extends RecyclerView.Adapter {
    private final static int NUMBER = 1, TEXT = 2, HELEN = 3;
    List<Object> myList;

    public myAdapter(List aList){
        myList = aList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TestViewHolder(parent);

//        if(viewType == 1){
//            childView = inflater.inflate(R.layout.cardview, parent, false);
//            return new myViewHolder(childView);
//        }
//        else if(viewType ==2){
//            childView = inflater.inflate(R.layout.integer_layout, parent,false);
//            return new textViewHolder(childView);
//        }
//        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position){
        if(myList.get(position) instanceof String){
            return NUMBER;
        }
        if(myList.get(position) instanceof Integer){
            return TEXT;
        }
        if(myList.get(position) instanceof TestViewHolder){
            return  HELEN;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
