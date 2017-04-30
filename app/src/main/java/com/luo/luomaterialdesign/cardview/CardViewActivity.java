package com.luo.luomaterialdesign.cardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.luo.luomaterialdesign.Bean;
import com.luo.luomaterialdesign.R;
import com.luo.luomaterialdesign.drawerlayout.DrawerLayoutActivity;
import com.luo.luomaterialdesign.toolbar.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        initView();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initData() {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean("ToolBar简单使用", ToolBarActivity.class));
        list.add(new Bean("DrawerLayout的简单使用", DrawerLayoutActivity.class));
        adapter = new CardViewAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

}
