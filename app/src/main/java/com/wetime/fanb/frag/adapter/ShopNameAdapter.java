package com.wetime.fanb.frag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wetime.fanb.R;
import com.wetime.fanb.frag.bean.OrderPageBean;

import java.util.List;


/**
 * Created by zhoukang on 2017/4/17.
 */

public class ShopNameAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<OrderPageBean.DataBean.MerchantsBean> mData;
    private String mid;

    public ShopNameAdapter(Context context, List<OrderPageBean.DataBean.MerchantsBean> mData, String mid) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
        this.mid = mid;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mData.size();
    }

    @Override
    public OrderPageBean.DataBean.MerchantsBean getItem(int arg0) {
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
            convertView = mInflater.inflate(R.layout.item_shopname, null);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_name.setText(mData.get(position).getName());
        if (mData.get(position).getMid().equals(mid))
            holder.iv.setVisibility(View.VISIBLE);
        else
            holder.iv.setVisibility(View.INVISIBLE);
        return convertView;

    }

    public static final class ViewHolder {
        public TextView tv_name;
        public ImageView iv;


    }


}

