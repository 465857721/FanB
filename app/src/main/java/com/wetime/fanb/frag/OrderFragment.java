package com.wetime.fanb.frag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.king.batterytest.fbaselib.main.BaseFragment;
import com.king.batterytest.fbaselib.main.FApp;
import com.king.batterytest.fbaselib.utils.Tools;
import com.wetime.fanb.R;
import com.wetime.fanb.act.ChoiceShopActivity;
import com.wetime.fanb.act.LoginActivity;
import com.wetime.fanb.act.WebActivity;
import com.wetime.fanb.act.event.ChangeShopEvent;
import com.wetime.fanb.frag.adapter.HistoryAdapter;
import com.wetime.fanb.frag.bean.OrderPageBean;
import com.wetime.fanb.frag.iviews.IGetOrderPageView;
import com.wetime.fanb.frag.presenter.GetOrderPgaePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OrderFragment extends BaseFragment implements IGetOrderPageView {

    @Bind(R.id.tv_shopname)
    TextView tvShopname;
    @Bind(R.id.tv_todayorder)
    TextView tvTodayorder;
    @Bind(R.id.tv_shishou)
    TextView tvShishou;
    @Bind(R.id.tv_ordernum)
    TextView tvOrdernum;
    @Bind(R.id.lv_his)
    ListView lvHis;
    @Bind(R.id.ll_history)
    LinearLayout llHistory;
    @Bind(R.id.iv_down)
    ImageView ivDown;
    @Bind(R.id.ll_today)
    LinearLayout llToday;
    private String mid = "0";
    GetOrderPgaePresenter getOrderPgaePresenter;
    OrderPageBean bean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_order, null);
        ButterKnife.bind(this, v);
        EventBus.getDefault().register(this);
        mid = spu.getValue("mid");
        if (mid.equals("")) {
            mid = "0";
        }
        getOrderPgaePresenter = new GetOrderPgaePresenter(this);
        getOrderPgaePresenter.getOrderResult();

        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onTimeOut() {
        super.onTimeOut();
        Tools.logout(getActivity());
        FApp.getInstance().removeALLActivity();
        Intent go = new Intent(getActivity(), LoginActivity.class);
        startActivity(go);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChangeShopEvent event) {
        mid = event.getMid();
        spu.setValue("mid", mid);
        getOrderPgaePresenter.getOrderResult();
    }

    @OnClick({R.id.tv_shopname, R.id.iv_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_down:
            case R.id.tv_shopname:
                if (bean == null || bean.getData().getMerchants().size() <= 1)
                    return;

                Intent choice = new Intent(getActivity(), ChoiceShopActivity.class);
                choice.putExtra("data", bean);
                getActivity().startActivity(choice);
                getActivity().overridePendingTransition(0, 0);
                break;

        }
    }

    @Override
    public String getMid() {
        return mid;
    }

    @Override
    public void onGetOrderResult(final OrderPageBean bean) {
        this.bean = bean;
        tvShishou.setText(bean.getData().getToday().getCashSum());
        tvOrdernum.setText(bean.getData().getToday().getCount());
        tvShopname.setText(bean.getData().getMerchant().getName());
        HistoryAdapter adapter = new HistoryAdapter(getActivity(), bean.getData().getLast3month());
        lvHis.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tvTodayorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goWeb(bean.getData().getToday().getHref());
            }
        });
        llToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goWeb(bean.getData().getToday().getHref());
            }
        });

        lvHis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goWeb(bean.getData().getLast3month().get(position).getHref());
            }
        });
        if (bean.getData().getMerchants().size() <= 1)
            ivDown.setVisibility(View.INVISIBLE);
    }

    private void goWeb(String url) {
        Intent goweb = new Intent(getActivity(), WebActivity.class);
        goweb.putExtra("url", url);
        getActivity().startActivity(goweb);

    }
}
