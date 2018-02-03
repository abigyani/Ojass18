package in.nitjsr.ojass.Utils;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Aditya on 13-12-2016.
 */

public class FirebaseInstanceIdService extends com.google.firebase.iid.FirebaseInstanceIdService {

    private static final String TAG="FirebaseInsIdService";

    @Override
    public void onTokenRefresh() {
        String RefreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"New Token : "+RefreshedToken);
        //Toast.makeText(getApplicationContext(),RefreshedToken,Toast.LENGTH_LONG).show();
        //EventBus.getDefault().post(new FirebaseRegComplete());
    }
}
