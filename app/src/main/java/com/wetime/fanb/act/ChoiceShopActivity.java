package com.wetime.fanb.act;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.king.batterytest.fbaselib.main.BaseActivity;
import com.wetime.fanb.R;
import com.wetime.fanb.act.event.ChangeShopEvent;
import com.wetime.fanb.frag.adapter.ShopNameAdapter;
import com.wetime.fanb.frag.bean.OrderPageBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoiceShopActivity extends BaseActivity {


    @Bind(R.id.tv_cancel)
    TextView tvCancel;
    @Bind(R.id.rl_choiceshop)
    RelativeLayout rlChoiceshop;
    @Bind(R.id.lv_shop)
    ListView lvShop;

    private OrderPageBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choiceshop);
        ButterKnife.bind(this);
        bean = (OrderPageBean) getIntent().getSerializableExtra("data");
        ShopNameAdapter adapter = new ShopNameAdapter(mContext,
                bean.getData().getMerchants(),
                bean.getData().getMerchant().getMid());
        lvShop.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lvShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onBackPressed();
                EventBus.getDefault().post(
                        new ChangeShopEvent(bean.getData().getMerchants().get(position).getMid()));

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    @OnClick({R.id.tv_cancel, R.id.rl_choiceshop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                onBackPressed();
                break;
            case R.id.rl_choiceshop:
                onBackPressed();
                break;
        }
    }
}
