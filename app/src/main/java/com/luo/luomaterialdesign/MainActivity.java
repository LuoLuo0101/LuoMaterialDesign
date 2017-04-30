package com.luo.luomaterialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.luo.luomaterialdesign.drawerlayout.DrawerLayoutActivity;
import com.luo.luomaterialdesign.toolbar.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

}
