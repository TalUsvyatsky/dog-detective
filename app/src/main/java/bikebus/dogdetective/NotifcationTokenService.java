package bikebus.dogdetective;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Keep app tokens for Firebase Messaging updated for push notifications
 */

public class NotifcationTokenService extends FirebaseInstanceIdService {

    private static final String TAG = DogMap.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        FirebaseMessaging.getInstance().subscribeToTopic("dogs");
        // TODO: Implement this method to send any registration to your app's servers.
        //sendRegistrationToServer(refreshedToken);
    }
}
