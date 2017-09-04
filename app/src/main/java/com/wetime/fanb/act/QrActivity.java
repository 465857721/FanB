package com.wetime.fanb.act;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.king.batterytest.fbaselib.main.BaseActivity;
import com.king.batterytest.fbaselib.utils.DownLoadImageService;
import com.king.batterytest.fbaselib.utils.Tools;
import com.wetime.fanb.R;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QrActivity extends BaseActivity {


    @Bind(R.id.tv_download)
    TextView tvDownload;
    @Bind(R.id.iv_qr)
    ImageView ivQr;
    @Bind(R.id.btn_back)
    ImageView btnBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_head)
    RelativeLayout rlHead;


    private Handler mHandler;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        ButterKnife.bind(this);
        mHandler = new Handler();
        if (getIntent() != null) {
            url = getIntent().getStringExtra("url");
            Glide.with(this).load(url).into(ivQr);
        } else {
            onBackPressed();
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick({R.id.btn_back, R.id.tv_download})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.tv_download:
                downQRcode(url);
                break;
        }
    }

    private void downQRcode(String url) {
        DownLoadImageService service = new DownLoadImageService(getApplicationContext(),
                url,
                new DownLoadImageService.ImageDownLoadCallBack() {

                    @Override
                    public void onDownLoadSuccess(File file) {
                    }

                    @Override
                    public void onDownLoadSuccess(Bitmap bitmap) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Tools.toastInBottom(getApplication(), "保存成功");
                            }
                        });

                    }

                    @Override
                    public void onDownLoadFailed() {
                        Tools.toastInBottom(QrActivity.this, "保存失败");
                    }
                });
        //启动图片下载线程
        new Thread(service).start();
    }
}
