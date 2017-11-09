package com.atguigu.android.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.atguigu.android.R;
import com.atguigu.android.afinal.AfinalActivity;
import com.atguigu.android.butterknife.ButterknifeActivity;
import com.atguigu.android.eventbus.EventBusActivity;
import com.atguigu.android.glide.activity.GlideActivity;
import com.atguigu.android.imageloader.acitvity.ImageLoaderActivity;
import com.atguigu.android.json.activity.FastJsonActivity;
import com.atguigu.android.json.activity.GsonActivity;
import com.atguigu.android.json.activity.NativeJsonPraseActivity;
import com.atguigu.android.okhttp.activity.OKHttpActivity;
import com.atguigu.android.okhttp.adapter.CommonFrameFragmentAdapter;
import com.atguigu.android.okhttp.base.BaseFragment;
import com.atguigu.android.picasso.activity.PicassoActivity;
import com.atguigu.android.recyclervview.RecyclerViewActivity;
import com.atguigu.android.volley.VolleyActivity;
import com.atguigu.android.xutils3.XUtils3MainActivity;

/**
 * 作者：尚硅谷-杨光福 on 2016/7/21 19:27
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：常用框架Fragment
 */
public class CommonFrameFragment extends BaseFragment {

    private ListView mListView;

    private String[] datas;

    private CommonFrameFragmentAdapter adapter;

    private static final String TAG = CommonFrameFragment.class.getSimpleName();//"CommonFrameFragment"

    @Override
    protected View initView() {

        Log.e(TAG, "常用框架Fragment页面被初始化了...");

        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        mListView = (ListView) view.findViewById(R.id.listview);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String data = datas[position];//okhttp

                if (data.toLowerCase().equals("okhttp")) {
                    // 点击条目跳转到OKHttp页面
                    Intent intent = new Intent(mContext, OKHttpActivity.class);
                    mContext.startActivity(intent);

                } else if (data.toLowerCase().equals("nativejsonprase")) {
                    // 点击条目跳转到手动JSON解析页面
                    Intent intent = new Intent(mContext, NativeJsonPraseActivity.class);
                    mContext.startActivity(intent);

                } else if (data.toLowerCase().equals("gson")) {
                    // 点击条目跳转到Gson解析页面
                    Intent intent = new Intent(mContext, GsonActivity.class);
                    mContext.startActivity(intent);

                } else if(data.toLowerCase().equals("fastjson")){
                    // 点击条目跳转到FastJson解析页面
                    Intent intent = new Intent(mContext, FastJsonActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("xutils3")){
                    // 点击条目跳转到FastJson解析页面
                    Intent intent = new Intent(mContext, XUtils3MainActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("afinal")) {
                    // 点击条目跳转到Afinal页面
                    Intent intent = new Intent(mContext, AfinalActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("volley")) {
                    // 点击条目跳转到VolleyActivity页面
                    Intent intent = new Intent(mContext, VolleyActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("eventbus")) {
                    // 点击条目跳转到EventBusActivity页面
                    Intent intent = new Intent(mContext, EventBusActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("butterknife")) {
                    // 点击条目跳转到Butterknife页面
                    Intent intent = new Intent(mContext, ButterknifeActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("imageloader")) {
                    // 点击条目跳转到Imageloader页面
                    Intent intent = new Intent(mContext, ImageLoaderActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("picasso")) {
                    // 点击条目跳转到picasso页面
                    Intent intent = new Intent(mContext, PicassoActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("recyclerview")) {
                    // 点击条目跳转到RecyclerView页面
                    Intent intent = new Intent(mContext, RecyclerViewActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("glide")) {
                    // 点击条目跳转到Glide页面
                    Intent intent = new Intent(mContext, GlideActivity.class);
                    startActivity(intent);
                }

                // 点击位置的显示
                Toast.makeText(mContext, "data==" + data, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    protected void initData() {
        super.initData();

        Log.e(TAG, "常用框架Fragment数据被初始化了...");

        //准备数据
        datas = new String[]{"OKHttp", "nativeJsonPrase", "Gson", "FastJson", "xUtils3", "Afinal", "Volley","Eventbus","Butterknife","Imageloader","Picasso","RecyclerView","Glide", "Retrofit2", "Fresco", "greenDao", "RxJava","jcvideoplayer", "pulltorefresh", "Expandablelistview", "UniversalVideoView", "....."};

        //设置适配器
        adapter = new CommonFrameFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
