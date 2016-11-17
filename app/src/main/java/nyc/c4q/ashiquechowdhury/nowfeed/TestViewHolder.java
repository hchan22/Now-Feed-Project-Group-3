//package nyc.c4q.ashiquechowdhury.nowfeed;
//
//import android.content.Context;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//
//public class TestViewHolder extends RecyclerView.ViewHolder {
//    private final BuzzFeedAdapter mAdapter;
//    private final View mItemView;
//    private RecyclerView recycle;
//    private Context context;
//sxxsxsashikisawesome
//    public TestViewHolder(View itemView) {
//        super(inflateView(itemView));
//        mItemView = inflateView(itemView);
//        context = mItemView.getContext();
//        recycle = (RecyclerView) mItemView.findViewById(R.id.helen_rv);
//        recycle.setLayoutManager(new LinearLayoutManager(context));
//        mAdapter = new BuzzFeedAdapter(context);
//        recycle.setAdapter(mAdapter);
//
//    }
//
//    private static View inflateView(View parent) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        return inflater.inflate(R.layout.buzz_card_view, (ViewGroup) parent, false);
//    }
//
//}
