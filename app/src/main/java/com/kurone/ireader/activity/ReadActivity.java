package com.kurone.ireader.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;

import com.kurone.ireader.R;
import com.kurone.ireader.adapter.ReadPagerAdapter;
import com.kurone.ireader.base.BaseActivity;
import com.kurone.ireader.utils.CharsetDetector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ReadActivity extends BaseActivity {

    @BindView(R.id.vp_read_main)
    ViewPager vpReadMain;
    private Unbinder unbinder;
    private BufferedReader br;
    private CharBuffer buffer;
    private ReadPagerAdapter adapter;

    @Override
    protected boolean isShowActionBar() {
        return true;
    }

    @Override
    protected void setViewObject() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void paramInitialize() {
        Intent intent = getIntent();
        String bookName = intent.getStringExtra("bookName");
        InputStream is;
        buffer = CharBuffer.allocate(16000);
        try {
            is = getAssets().open(bookName);
            Charset charset = CharsetDetector.detect(is);
            br = new BufferedReader(new InputStreamReader(is, charset));
            br.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        adapter = new ReadPagerAdapter(buffer);
        vpReadMain.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_read;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
