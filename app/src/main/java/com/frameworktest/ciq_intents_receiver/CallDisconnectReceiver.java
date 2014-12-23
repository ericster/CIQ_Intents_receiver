package com.frameworktest.ciq_intents_receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CallDisconnectReceiver extends BroadcastReceiver {

    public CallDisconnectReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("diagandroid.phone.detailedCallState".equals(intent.getAction())) {
            String str1 = intent.getStringExtra("CallState");
            String str2 = intent.getStringExtra("CallNumber");
            String str3 = intent.getStringExtra("CallCode");
            Log.d("CIQ_Intent_test", "Received Intent=" + intent.getAction() +
                    " CallNumber=" + str2 + " CallState=" + str1 + " CallCode=" + str3);

            showNotification(context);

        }

    }

    private void showNotification(Context context) {
        Notification.Builder mBuilder =
                new Notification.Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("CIQ Intents ")
                        .setContentText("Call disconnect received!");
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }
}
