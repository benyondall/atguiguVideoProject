package com.atguigu.android.glide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.atguigu.android.R;
import com.atguigu.android.glide.adapter.GlideRecyclerviewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GlideRecyclerviewActivity extends Activity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_glide)
    RecyclerView rvGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_recyclerview);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("Glide在RecyclerView中加载图片");

        // 初始化Recyclerview
        GlideRecyclerviewAdapter glideRecyclerviewAdapter = new GlideRecyclerviewAdapter(this);
        rvGlide.setAdapter(glideRecyclerviewAdapter);
        rvGlide.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
