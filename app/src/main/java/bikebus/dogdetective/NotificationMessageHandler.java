package bikebus.dogdetective;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Handle push notification datat incoming from Firebase Messaging
 */

public class NotificationMessageHandler extends FirebaseMessagingService {

    private static final String TAG = DogMap.class.getSimpleName();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
         Intent in = new Intent();
        in.setAction("REFRESH_DOG_MAP");
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(in);
    }
}
