package com.example.eric.myapplication;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;
/**
 * Created by eric on 9/25/2017.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {


    public void onReceive(final Context context, Intent intent) {
        AlarmActivity inst = AlarmActivity.instance();
        inst.setAlarmText("Alarm! Wake up! Wake up");

        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null)
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone ringtone= RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();


        ComponentName comp= new ComponentName(context.getPackageName(),AlarmService.class.getName());
        startWakefulService(context,(intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}