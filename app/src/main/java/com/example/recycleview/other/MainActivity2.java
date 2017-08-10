package com.example.recycleview.other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.recycleview.R;
import com.example.recycleview.one.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements HideScrollListener{

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecycleViewAdapter adapter;
    private List<String> data = new ArrayList<>();
    private Toolbar toolbar;
    private LinearLayout llBottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        llBottomMenu = (LinearLayout)findViewById(R.id.ll_buttom);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecycleViewAdapter(this);
        data.addAll(getData());
        adapter.setData(data);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new FabScrollListener(this));
    }

    private Collection<? extends String> getData() {
        List<String> d = new ArrayList<>();
        for (int i=0;i<100;i++){
            d.add(String.valueOf(i));
        }
        return d;
    }

    @Override
    public void onHide() {
        //隐藏动画
        toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(3));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) llBottomMenu.getLayoutParams();

        llBottomMenu.animate().translationY(llBottomMenu.getHeight() + layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
    }

    @Override
    public void onShow() {
        // 显示动画--属性动画
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) llBottomMenu.getLayoutParams();
        llBottomMenu.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
    }
}
