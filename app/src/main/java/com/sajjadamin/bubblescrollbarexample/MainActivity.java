package com.sajjadamin.bubblescrollbarexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.trendyol.bubblescrollbarlib.BubbleScrollBar;
import com.trendyol.bubblescrollbarlib.BubbleTextProvider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public BubbleScrollBar bubbleScrollBar;
    public List<String> data = new ArrayList<>();
    public Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //UI components
        recyclerView = findViewById(R.id.recyclerView);
        bubbleScrollBar = findViewById(R.id.bubbleScrollBar);
        //Generate data for recyclerview
        for (int i = 1; i <= 100; i++){
            data.add("" + i);
        }
        //Set adapter
        adapter = new Adapter(data,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Adding bubble scroll view
        bubbleScrollBar.attachToRecyclerView(recyclerView);
        bubbleScrollBar.setBubbleTextProvider(new BubbleTextProvider() {
            @Override
            public String provideBubbleText(int i) {
                return data.get(i);
            }
        });
    }
}