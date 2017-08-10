package com.example.recycleview.one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recycleview.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecycleViewAdapter adapter;
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.rv_behavior);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecycleViewAdapter(this);
        data.addAll(getData());
        adapter.setData(data);
        recyclerView.setAdapter(adapter);
    }

    private Collection<? extends String> getData() {
        List<String> d = new ArrayList<>();
        for (int i=0;i<100;i++){
            d.add(String.valueOf(i));
        }
        return d;
    }
}
