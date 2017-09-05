package com.wetime.fanb.frag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wetime.fanb.R;
import com.wetime.fanb.frag.bean.OrderPageBean;

import java.util.List;


/**
 * Created by zhoukang on 2017/4/17.
 */

public class HistoryAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<OrderPageBean.DataBean.Last3monthBean> mData;

    public HistoryAdapter(Context context, List<OrderPageBean.DataBean.Last3monthBean> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mData.size();
    }

    @Override
    public OrderPageBean.DataBean.Last3monthBean getItem(int arg0) {
        // TODO Auto-generated method stub
        return mData.get(arg0);
    }


    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_history, null);
            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            holder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            holder.tv_line = (TextView) convertView.findViewById(R.id.tv_line);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_date.setText(mData.get(position).getDt());
        holder.tv_num.setText(mData.get(position).getAmount() + " 元");
        if (position == mData.size() - 1)
            holder.tv_line.setVisibility(View.GONE);

        return convertView;

    }

    public static final class ViewHolder {
        public TextView tv_date;
        public TextView tv_num;
        public TextView tv_line;


    }


}

