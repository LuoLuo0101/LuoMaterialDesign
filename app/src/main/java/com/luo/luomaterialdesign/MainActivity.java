package com.luo.luomaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luo.luomaterialdesign.toolbar.ToolBarActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.Listener {
    private RecyclerView recyclerView;
    private ArrayList<Bean> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setData();
    }

    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new Bean("ToolBar", ToolBarActivity.class));
    }

    private void setData() {
        adapter = new MyAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v, int position) {
        Bean bean = list.get(position);
        Class clazz = bean.getClazz();
        if (clazz != null) {
            startActivity(new Intent(this, clazz));
        }
    }
}
