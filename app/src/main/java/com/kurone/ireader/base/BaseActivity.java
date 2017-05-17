package com.kurone.ireader.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kurone.ireader.R;

/**
 * Superclass of Activity Created by Kurone on 2017/4/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private TextView mBarTitle;
    private ImageView mBarBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        paramInitializeBeforeView();
        super.setContentView(R.layout.lin_global_pages);
        setContentView(getContentView());
        initActionBar(isShowActionBar());
        setViewObject();
        paramInitialize();
        setListener();
    }

    /**
     * 封装方法：选择是否初始化预置的ActionBar，通过isShowActionBar()的返回值实现
     * @param isShowActionBar:true:初始化；false:不初始化
     */
    private void initActionBar(boolean isShowActionBar) {
        RelativeLayout mGlobalActionBar = getViewById(R.id.rel_global_actionbar);
        if (isShowActionBar) {
            mBarTitle = getViewById(R.id.tv_global_title);
            mBarBack = getViewById(R.id.img_global_back);
            mBarBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            mGlobalActionBar.setVisibility(View.GONE);
        }
    }

    /**
     * 封装方法：设置通用ActionBar的标题
     * @param content:标题内容
     */

    protected void setActionBarTitle(String content) {
        mBarTitle.setText(content);
    }

    /**
     * 必须实现：是否需要个人预置的ActionBar
     * @return :true:需要 false:不需要
     */
    protected abstract boolean isShowActionBar();

    /**
     * 封装方法：将通用ActionBar与主内容进行拼接
     * @return :拼接好的视图
     */

    private View getContentView() {
        LinearLayout mGlobalPages = getViewById(R.id.lin_global_pages);
        View convertView = LayoutInflater.from(this).inflate(getLayoutId(), null);
        convertView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mGlobalPages.addView(convertView);
        return mGlobalPages;
    }

    /**
     * 必须实现：找到布局中控件的ID(所有findViewById集中至此方法)
     */
    protected abstract void setViewObject();

    /**
     * 封装方法：Activity跳转方法
     *
     * @param activityClass:要跳转到的Activity Class
     * @param isFinish:跳转后是否结束当前Activity
     */
    protected void goToActivity(Class<? extends BaseActivity> activityClass, boolean isFinish) {
        startActivity(new Intent(this, activityClass));
        if (isFinish)
            finish();
    }

    /**
     * 必须实现：初始化参数
     */
    protected abstract void paramInitialize();

    /**
     * 封装方法：自动将控件类型强制转换为应该转换为的类型
     *
     * @param resId:控件ID（利用R文件）
     * @param <T>:View的所有子类（即包括了所有控件类型）
     * @return :返回已经转好的控件对象
     */

    protected <T extends View> T getViewById(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * 必须实现：设置当前Activity的主布局
     *
     * @return :layout布局ID
     */
    protected abstract int getLayoutId();

    /**
     * 可选实现：设置在应用主页面布局前需要设置的参数（eg.设置窗口全屏，隐藏状态栏,
     * 状态保存还原，数据固有化存储等）
     */

    protected void paramInitializeBeforeView() {
    }

    /**
     * 可选实现：设置控件的监听及监听事件等
     */
    protected void setListener() {
    }

    /**
     * 封装方法：设置吐司
     * @param context:设置吐司内容
     */
    protected void printToast(String context) {
        Toast.makeText(this, context, Toast.LENGTH_SHORT).show();
    }

}
