package com.example.mock;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;

public class FCMTokenManager {
    
    public interface TokenCallback {
        void onSuccess(String token);
        void onError(String error);
    }
    
    public static void getCurrentToken(Context context, TokenCallback callback) {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        callback.onError("Failed to get FCM token: " + task.getException());
                        return;
                    }
                    
                    String token = task.getResult();
                    if (token != null && !token.isEmpty()) {
                        callback.onSuccess(token);
                    } else {
                        callback.onError("FCM token is null or empty");
                    }
                });
    }
}
