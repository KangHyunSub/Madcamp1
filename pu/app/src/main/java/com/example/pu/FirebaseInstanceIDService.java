package com.example.pu;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG= "MyFirebaseIDService";

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,token);

        sendRegistrationToServer(token);
    }
    //앱서버로 토큰을 보낼때 활용

    private void sendRegistrationToServer(String token) {
    }
}
