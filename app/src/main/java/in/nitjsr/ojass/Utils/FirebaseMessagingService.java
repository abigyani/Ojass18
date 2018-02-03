package in.nitjsr.ojass.Utils;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

import in.nitjsr.ojass.Activities.MainActivity;
import in.nitjsr.ojass.R;


/**
 * Created by Aditya on 13-12-2016.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private static final String TAG ="FirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"FROM :"+ remoteMessage.getFrom());

        if(remoteMessage.getData().size()>0)
        {
            Log.d(TAG,"Message : "+ remoteMessage.getData());

        }
        if(remoteMessage.getNotification()!=null)
        {
            Log.d(TAG,"Message Body :"+ remoteMessage.getNotification().getBody());
            handleNotification(remoteMessage.getNotification().getBody());
        }


    }

    private void handleNotification(String body) {

        Intent intent =new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT);

        Uri notificationSound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifiBuilder= new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Ojass 17")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notificationSound)
                .setContentIntent(pendingIntent);


        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notifiBuilder.build());




    }
}
