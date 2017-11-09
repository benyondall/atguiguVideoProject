package com.atguigu.android.imageloader.acitvity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.atguigu.android.R;
import com.atguigu.android.imageloader.adapter.ImageloaderGridviewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageloaderGridviewActivity extends Activity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.gv_imageloader_gridview)
    GridView gvImageloaderGridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imageloader_gridview);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        // 标题
        tvTitle.setText("Imageloader应用在Gridview中");

        // 初始化Gridview
        ImageloaderGridviewAdapter imageloaderGridviewAdapter = new ImageloaderGridviewAdapter(this);

        gvImageloaderGridview.setAdapter(imageloaderGridviewAdapter);
    }
}
