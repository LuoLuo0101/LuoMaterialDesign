package com.luo.luomaterialdesign.drawerlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.luo.luomaterialdesign.Bean2;
import com.luo.luomaterialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class DrawerLayoutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolBar;
    private NavigationView navigationView;
    private FloatingActionButton fab;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);
        initView();
        initData();
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initData() {
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);      // 设置 Home 键有效
//            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_compass);   // 默认是箭头
        }
        navigationView.setCheckedItem(R.id.nav_mail);
        navigationView.setNavigationItemSelectedListener(this);
        fab.setOnClickListener(this);
        swipeRefresh.setOnRefreshListener(this);
        List<Bean2> list = new ArrayList<>();
        list.add(new Bean2("image1", android.R.drawable.btn_default));
        list.add(new Bean2("image2", android.R.drawable.btn_dialog));
        list.add(new Bean2("image3", android.R.drawable.btn_dropdown));
        list.add(new Bean2("image4", android.R.drawable.btn_minus));
        list.add(new Bean2("image5", android.R.drawable.btn_plus));
        list.add(new Bean2("image6", android.R.drawable.btn_radio));
        list.add(new Bean2("image7", android.R.drawable.btn_star));
        list.add(new Bean2("image8", android.R.drawable.btn_star_big_on));
        list.add(new Bean2("image9", android.R.drawable.btn_star_big_off));
        list.add(new Bean2("image10", android.R.drawable.ic_btn_speak_now));
        list.add(new Bean2("image11", android.R.drawable.ic_delete));
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // 打开抽屉
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_call:
                // 关闭抽屉
                drawerLayout.closeDrawers();
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_friends:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_mail:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(v, "我也不知道我在干啥", Snackbar.LENGTH_SHORT)
                        .setAction("这个是Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(DrawerLayoutActivity.this, "Snackbar-setAction", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
        }
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setRefreshing(false);
            }
        }, 3000);
    }
}
