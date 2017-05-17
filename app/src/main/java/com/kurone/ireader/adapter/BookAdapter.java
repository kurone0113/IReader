package com.kurone.ireader.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kurone.ireader.R;
import com.kurone.ireader.entity.Book;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qihao on 2017/5/16.
 */

public class BookAdapter extends BaseAdapter {
    private List<Book> mBook;

    public BookAdapter(List<Book> mBook) {
        this.mBook = mBook;
    }

    @Override
    public int getCount() {
        return mBook == null ? 0 : mBook.size();
    }

    @Override
    public Object getItem(int position) {
        return mBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book data = mBook.get(position);
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.pIcon.setImageResource(data.getIcon());
        holder.pName.setText(data.getName());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.p_icon)
        ImageView pIcon;
        @BindView(R.id.p_name)
        TextView pName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
