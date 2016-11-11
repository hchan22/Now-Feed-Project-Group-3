package nyc.c4q.ashiquechowdhury.nowfeed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<Object> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateNameList();
        mRecyclerView = (RecyclerView) findViewById(R.id.rView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new myAdapter(nameList));
    }

    public void populateNameList(){
        nameList = new ArrayList<>();
        nameList.add("Ashique");
        nameList.add(12);
        nameList.add("Ridita");
        nameList.add("Helen");
        nameList.add(13);
    }
}