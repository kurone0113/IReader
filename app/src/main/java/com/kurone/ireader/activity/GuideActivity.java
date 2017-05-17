package com.kurone.ireader.activity;

import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.kurone.ireader.R;
import com.kurone.ireader.adapter.ViewPagerAdapter;
import com.kurone.ireader.base.BaseActivity;
import com.kurone.ireader.utils.SPUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GuideActivity extends BaseActivity {

    @BindView(R.id.vp_guide_main)
    ViewPager vpGuideMain;
    private Unbinder unbinder;
    private ViewPagerAdapter adapter;

    @Override
    protected boolean isShowActionBar() {
        return false;
    }

    @Override
    protected void paramInitializeBeforeView() {
        super.paramInitializeBeforeView();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        boolean isFirst = SPUtils.readBoolean("isFirst");
        if (isFirst) {
            SPUtils.writeBoolean("isFirst", false);
        } else {
            goToActivity(SplashActivity.class, true);
        }
    }

    @Override
    protected void setViewObject() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void paramInitialize() {
        adapter = new ViewPagerAdapter();
        vpGuideMain.setAdapter(adapter);
        vpGuideMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private Timer timer;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == adapter.getCount() - 1) {
                    timer = new Timer(false);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            goToActivity(SplashActivity.class, true);
                        }
                    }, 3000);
                } else {
                    if (timer != null) timer.cancel();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
