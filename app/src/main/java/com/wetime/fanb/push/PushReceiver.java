package com.wetime.fanb.push;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

import com.king.batterytest.fbaselib.utils.GsonUtils;
import com.king.batterytest.fbaselib.utils.SharePreferenceUtil;
import com.king.batterytest.fbaselib.utils.SpeechUtils;
import com.king.batterytest.fbaselib.utils.Tools;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import com.wetime.fanb.R;
import com.wetime.fanb.act.LoadingActivity;
import com.wetime.fanb.push.model.PushToneModel;

import static android.content.Context.NOTIFICATION_SERVICE;

public class PushReceiver extends XGPushBaseReceiver {
    private final String TAG = "TPush";

    @Override
    public void onRegisterResult(Context context, int i, XGPushRegisterResult xgPushRegisterResult) {

    }

    @Override
    public void onUnregisterResult(Context context, int i) {

    }

    @Override
    public void onSetTagResult(Context context, int i, String s) {

    }

    @Override
    public void onDeleteTagResult(Context context, int i, String s) {

    }

    @Override
    public void onTextMessage(Context context, XGPushTextMessage xgPushTextMessage) {
        Log.d(TAG, xgPushTextMessage.getContent());
        PushToneModel tone = GsonUtils.getGsonInstance().fromJson(
                xgPushTextMessage.getCustomContent(), PushToneModel.class);
        showNotice(context, xgPushTextMessage.getTitle(), xgPushTextMessage.getContent(), tone.getSound_enabled());
    }

    @Override
    public void onNotifactionClickedResult(Context context, XGPushClickedResult xgPushClickedResult) {

    }

    @Override
    public void onNotifactionShowedResult(Context context, XGPushShowedResult xgPushShowedResult) {

    }

    private void showNotice(Context mContext, String title, String msg, String Sound_enabled) {
        SharePreferenceUtil spu = Tools.getSpu(mContext);
        if (TextUtils.isEmpty(spu.getToken()))
            return;
        if (Sound_enabled.equals("1")) {
            SpeechUtils speechUtils = SpeechUtils.getsSpeechUtils(mContext);
            speechUtils.speak(msg);
        }


        Intent intent;
        intent = new Intent(mContext, LoadingActivity.class);


        PendingIntent pendingIntent =
                PendingIntent.getActivity(mContext, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager mNotificationManager =
                (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext);
        mBuilder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.login_icon))
                .setContentTitle(mContext.getString(R.string.app_name))//设置通知栏标题
                .setContentText(msg) //设置通知栏显示内容
                .setContentIntent(pendingIntent) //设置通知栏点击意图
                .setTicker(msg) //通知首次出现在通知栏，带上升动画效果的
                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
                .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setDefaults(Notification.DEFAULT_VIBRATE);//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
        //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
        mBuilder.setSmallIcon(R.drawable.login_icon);//设置通知小ICON


        mNotificationManager.notify(1000, mBuilder.build());
    }

    private boolean isForeground(Context context) {
        if (context != null) {
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
            String currentPackageName = cn.getPackageName();
            if (!TextUtils.isEmpty(currentPackageName) && currentPackageName.equals(context.getPackageName())) {
                return true;
            }
            return false;
        }
        return false;
    }


}
