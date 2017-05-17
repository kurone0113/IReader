package com.kurone.ireader.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.kurone.ireader.R;
import com.kurone.ireader.view.ReadView;

import java.nio.CharBuffer;

/**
 * Created by Kurone on 2017/5/17.
 */

public class ReadPagerAdapter extends PagerAdapter {
    ReadView rvItemReadContext;
    RelativeLayout relItemReadBackground;
    private CharBuffer data;
    private int charNum;

    public ReadPagerAdapter(CharBuffer data) {
        super();
        this.data = data;
    }

    @Override
    public int getCount() {
        return 300;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.item_read_pager, null);
        rvItemReadContext = (ReadView) itemView.findViewById(R.id.rv_item_read_context);
        relItemReadBackground = (RelativeLayout) itemView.findViewById(R.id.rel_item_read_background);
        //TODO:getLayout方法返回值为空
        if (rvItemReadContext.getLayout() != null){
            charNum += rvItemReadContext.getCharNum();
        }
        data.position(charNum);
        rvItemReadContext.setText(data);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
