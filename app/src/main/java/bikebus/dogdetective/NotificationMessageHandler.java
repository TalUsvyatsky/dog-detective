package bikebus.dogdetective;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Handle push notification datat incoming from Firebase Messaging
 */

public class NotificationMessageHandler extends FirebaseMessagingService {

    private static final String TAG = NotificationMessageHandler.class.getSimpleName();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent in = new Intent();
        in.setAction("REFRESH_DOG_MAP");
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(in);
        Map<String, String> data = remoteMessage.getData();
        Log.d(TAG,data.toString());
        if (data.containsKey("superlike") && data.get("superlike").equals("true")) {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.mipmap.dog_1)
                            .setContentTitle("Best boye spotted!")
                            .setContentText("A dog has been superliked");
            Intent resultIntent = new Intent(this, DogMap.class);
            PendingIntent resultPendingIntent =
                    PendingIntent.getActivity(
                            this,
                            0,
                            resultIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            // Sets an ID for the notification
            int mNotificationId = 001;
            // Gets an instance of the NotificationManager service
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());
        }
    }
}
