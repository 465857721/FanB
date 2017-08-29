package com.wetime.fanb.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wetime.fanb.R;
import com.wetime.fanb.act.ChoiceShopActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OrderFragment extends Fragment {

    @Bind(R.id.tv_shopname)
    TextView tvShopname;
    @Bind(R.id.tv_todayorder)
    TextView tvTodayorder;
    @Bind(R.id.tv_shishou)
    TextView tvShishou;
    @Bind(R.id.tv_ordernum)
    TextView tvOrdernum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_order, null);

        ButterKnife.bind(this, v);
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_shopname})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_shopname:
                Intent choice = new Intent(getActivity(), ChoiceShopActivity.class);
                getActivity().startActivity(choice);
                getActivity().overridePendingTransition(0, 0);
                break;

        }
    }
}
