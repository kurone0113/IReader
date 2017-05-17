package com.kurone.ireader.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kurone.ireader.R;
import com.kurone.ireader.adapter.BookAdapter;
import com.kurone.ireader.base.BaseActivity;
import com.kurone.ireader.entity.Book;
import com.kurone.ireader.utils.BookSearchManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @BindView(R.id.tv_home_lastread)
    TextView mTvHomeLastread;
    @BindView(R.id.lv_home_booklist)
    ListView mLvHomeBooklist;
    private Unbinder unbinder;
    private List<Book> bookList;
    private BookAdapter adapter;

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
        bookList = BookSearchManager.getBookList();
        adapter = new BookAdapter(bookList);
        mLvHomeBooklist.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void setListener() {
        mTvHomeLastread.setOnClickListener(this);
        mLvHomeBooklist.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Book book = bookList.get(position);
        Intent intent = new Intent(this,ReadActivity.class);
        intent.putExtra("bookName",book.getName());
        startActivity(intent);
    }
}
