package com.example.mock;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PaymentApiService {
    private Context context;
    private RequestQueue requestQueue;

    public PaymentApiService(Context context) {
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public interface PaymentListCallback {
        void onSuccess(List<PaymentModel> payments);
        void onError(String error);
    }

    public void getAllPayments(int ownerId, PaymentListCallback callback) {
        String url = "http://192.168.101.6/BoardEase2/get_all_payments.php?owner_id=" + ownerId;
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        List<PaymentModel> payments = new ArrayList<>();
                        JSONArray paymentsArray = response.getJSONArray("payments");
                        for (int i = 0; i < paymentsArray.length(); i++) {
                            JSONObject paymentObj = paymentsArray.getJSONObject(i);
                            PaymentModel payment = new PaymentModel();
                            payment.setId(paymentObj.getInt("id"));
                            payment.setAmount(paymentObj.getDouble("amount"));
                            payment.setStatus(paymentObj.getString("status"));
                            payment.setDate(paymentObj.getString("date"));
                            payments.add(payment);
                        }
                        callback.onSuccess(payments);
                    } catch (JSONException e) {
                        callback.onError("Error parsing payments: " + e.getMessage());
                    }
                },
                error -> callback.onError("Network error: " + error.getMessage()));
        
        requestQueue.add(request);
    }

    public void getPendingPayments(int ownerId, PaymentListCallback callback) {
        String url = "http://192.168.101.6/BoardEase2/get_pending_payments.php?owner_id=" + ownerId;
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        List<PaymentModel> payments = new ArrayList<>();
                        JSONArray paymentsArray = response.getJSONArray("payments");
                        for (int i = 0; i < paymentsArray.length(); i++) {
                            JSONObject paymentObj = paymentsArray.getJSONObject(i);
                            PaymentModel payment = new PaymentModel();
                            payment.setId(paymentObj.getInt("id"));
                            payment.setAmount(paymentObj.getDouble("amount"));
                            payment.setStatus(paymentObj.getString("status"));
                            payment.setDate(paymentObj.getString("date"));
                            payments.add(payment);
                        }
                        callback.onSuccess(payments);
                    } catch (JSONException e) {
                        callback.onError("Error parsing payments: " + e.getMessage());
                    }
                },
                error -> callback.onError("Network error: " + error.getMessage()));
        
        requestQueue.add(request);
    }

    public void getCompletedPayments(int ownerId, PaymentListCallback callback) {
        String url = "http://192.168.101.6/BoardEase2/get_completed_payments.php?owner_id=" + ownerId;
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        List<PaymentModel> payments = new ArrayList<>();
                        JSONArray paymentsArray = response.getJSONArray("payments");
                        for (int i = 0; i < paymentsArray.length(); i++) {
                            JSONObject paymentObj = paymentsArray.getJSONObject(i);
                            PaymentModel payment = new PaymentModel();
                            payment.setId(paymentObj.getInt("id"));
                            payment.setAmount(paymentObj.getDouble("amount"));
                            payment.setStatus(paymentObj.getString("status"));
                            payment.setDate(paymentObj.getString("date"));
                            payments.add(payment);
                        }
                        callback.onSuccess(payments);
                    } catch (JSONException e) {
                        callback.onError("Error parsing payments: " + e.getMessage());
                    }
                },
                error -> callback.onError("Network error: " + error.getMessage()));
        
        requestQueue.add(request);
    }
}
