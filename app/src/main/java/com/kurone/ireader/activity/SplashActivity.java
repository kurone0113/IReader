package com.kurone.ireader.activity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.kurone.ireader.R;
import com.kurone.ireader.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.kurone.ireader.R.id.tv_splash_timer;

public class SplashActivity extends BaseActivity implements View.OnClickListener {

    @BindView(tv_splash_timer)
    TextView mTvSplashTimer;
    private Unbinder unbinder;
    private int countDown = 4;
    private Timer timer;

    @Override
    protected boolean isShowActionBar() {
        return false;
    }

    @Override
    protected void paramInitializeBeforeView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void setViewObject() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void paramInitialize() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SplashActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String timerCount = getString(R.string.string_splash_timer);
                        timerCount = String.format(timerCount, --countDown);
                        mTvSplashTimer.setText(timerCount);
                        if (countDown == 0) {
                            goToActivity(HomeActivity.class, true);
                            timer.cancel();
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setListener() {
        mTvSplashTimer.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        goToActivity(HomeActivity.class, true);
        timer.cancel();
    }
}

