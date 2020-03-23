package com.example.shimmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ShimmerFrameLayout shimmerFrameLayout;
    RecyclerView recyclerView;
    RecyclerAdapter recylerViewAdapter;
    ArrayList<Integer> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        shimmerFrameLayout=findViewById(R.id.shimmer_layout);
        recyclerView = findViewById(R.id.recycler_veiw);
        models = new ArrayList<>();
        recylerViewAdapter = new RecyclerAdapter(models,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.hasFixedSize();
        recyclerView.setAdapter(recylerViewAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                models.add(1);
                models.add(2);
                models.add(3);
                models.add(4);
                models.add(5);
                models.add(6);
                models.add(7);
                models.add(8);
                models.add(9);
                models.add(10);
                models.add(11);
                models.add(12);
                models.add(13);
                models.add(14);
                models.add(15);
                models.add(16);
                models.add(17);
                recylerViewAdapter.stopShimmering();
                recylerViewAdapter.notifyDataSetChanged();
            }
        }, 10000);
    }

}
