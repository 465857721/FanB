package com.wetime.fanb.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.king.batterytest.fbaselib.main.BaseFragment;
import com.wetime.fanb.R;
import com.wetime.fanb.frag.adapter.ShopAdapter;
import com.wetime.fanb.frag.bean.ShopPageBean;
import com.wetime.fanb.frag.iviews.IGetShopPageView;
import com.wetime.fanb.frag.presenter.GetShopPgaePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ShopFragment extends BaseFragment implements IGetShopPageView {

    @Bind(R.id.lv_shop)
    ListView lvShop;

    private GetShopPgaePresenter getShopPgaePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_shop, null);
        ButterKnife.bind(this, v);
        getShopPgaePresenter = new GetShopPgaePresenter(this);
        getShopPgaePresenter.getOrderResult();
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onGetShopResult(ShopPageBean bean) {
        if (bean == null)
            return;
        ShopAdapter adapter = new ShopAdapter(getActivity(), bean.getData().getMerchants());
        lvShop.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        View footer = LayoutInflater.from(getActivity()).inflate(R.layout.item_shop_footer, null);
        ImageView iv = (ImageView) footer.findViewById(R.id.iv_footer);
        Glide.with(getActivity()).load(bean.getData().getBannerImg()).into(iv);
        lvShop.addFooterView(footer);
    }
}
