package com.wetime.fanb.frag.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wetime.fanb.R;
import com.wetime.fanb.act.QrActivity;
import com.wetime.fanb.act.WebActivity;
import com.wetime.fanb.frag.bean.ShopPageBean;

import java.util.List;


/**
 * Created by zhoukang on 2017/4/17.
 */

public class ShopAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ShopPageBean.DataBean.MerchantsBean> mData;
    private Context context;

    public ShopAdapter(Context context, List<ShopPageBean.DataBean.MerchantsBean> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mData.size();
    }

    @Override
    public ShopPageBean.DataBean.MerchantsBean getItem(int arg0) {
        // TODO Auto-generated method stub
        return mData.get(arg0);
    }


    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_shop, null);
            holder.tv_info = (TextView) convertView.findViewById(R.id.tv_info);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_qr = (TextView) convertView.findViewById(R.id.tv_qr);
            holder.tv_manage = (TextView) convertView.findViewById(R.id.tv_manage);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goWeb(mData.get(position).getHrefInfo());
            }
        });
        holder.tv_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goqr = new Intent(context, QrActivity.class);
                goqr.putExtra("url", mData.get(position).getImageCode());
                context.startActivity(goqr);
//                goWeb(mData.get(position).getHrefCode());
            }
        });
        holder.tv_manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData.get(position).getRole().equals("0"))
                    return;
                goWeb(mData.get(position).getHrefUser());
            }
        });
        if (mData.get(position).getRole().equals("1")) {
            holder.tv_manage.setTextColor(Color.parseColor("#575b64"));
            Drawable drawable = context.getResources().getDrawable(R.drawable.icon_manage_1);

            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
            holder.tv_manage.setCompoundDrawables(null, drawable, null, null);
        } else {
            holder.tv_manage.setTextColor(Color.parseColor("#c4c6ca"));
            Drawable drawable = context.getResources().getDrawable(R.drawable.icon_manage_0);

            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//必须设置图片大小，否则不显示
            holder.tv_manage.setCompoundDrawables(null, drawable, null, null);
        }

        return convertView;

    }

    public static final class ViewHolder {
        public TextView tv_info;
        public TextView tv_name;
        public TextView tv_qr;
        public TextView tv_manage;


    }

    private void goWeb(String url) {
        Intent goweb = new Intent(context, WebActivity.class);
        goweb.putExtra("url", url);
        context.startActivity(goweb);

    }

}

