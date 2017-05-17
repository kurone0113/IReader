package com.kurone.ireader.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kurone.ireader.R;
import com.kurone.ireader.adapter.BookAdapter;
import com.kurone.ireader.base.BaseActivity;
import com.kurone.ireader.utils.BookSearchManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.tv_home_lastread)
    TextView mTvHomeLastread;
    @BindView(R.id.lv_home_booklist)
    ListView mLvHomeBooklist;
    private Unbinder unbinder;

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
        setActionBarTitle("电子书列表");
        mLvHomeBooklist.setAdapter(new BookAdapter(BookSearchManager.getBookList()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
