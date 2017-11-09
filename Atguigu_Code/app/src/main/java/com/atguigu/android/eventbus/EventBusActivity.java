package com.atguigu.android.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.atguigu.android.R;
import com.atguigu.android.eventbus.event.MessageEvent;
import com.atguigu.android.eventbus.event.StickyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

// eventbus
public class EventBusActivity extends Activity {
    private TextView tv_title;
    private Button bt_eventbus_send;
    private Button bt_eventbus_sticky;
    private TextView tv_eventbus_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_bus);

        initView();

        initData();

        initListener();
    }

    private void initListener() {
        // 跳转到发送页面
        bt_eventbus_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EventBusActivity.this, EventBusSendActivity.class);

                startActivity(intent);
            }
        });

        // 发送粘性事件到发送页面
        bt_eventbus_sticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2 发送粘性事件
                EventBus.getDefault().postSticky(new StickyEvent("我是粘性事件"));

                // 跳转到发送数据页面
                Intent intent = new Intent(EventBusActivity.this, EventBusSendActivity.class);

                startActivity(intent);
            }
        });
    }

    private void initData() {
        tv_title.setText("EventBus");

        // 1注册广播
        EventBus.getDefault().register(EventBusActivity.this);
    }

    private void initView() {
        tv_title = (TextView)findViewById(R.id.tv_title);

        bt_eventbus_send = (Button)findViewById(R.id.bt_eventbus_send);
        bt_eventbus_sticky = (Button)findViewById(R.id.bt_eventbus_sticky);
        tv_eventbus_result = (TextView)findViewById(R.id.tv_eventbus_result);
    }


    // 5接收消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MesssageEventBus(MessageEvent event){

        // 显示接收的消息
        tv_eventbus_result.setText(event.name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 2 解注册
        EventBus.getDefault().unregister(EventBusActivity.this);
    }
}
