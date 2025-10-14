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

public class MaintenanceApiService {
    private Context context;
    private RequestQueue requestQueue;

    public MaintenanceApiService(Context context) {
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public interface MaintenanceApiCallback {
        void onSuccess(List<MaintenanceModel> maintenanceRequests);
        void onError(String error);
    }

    public interface SimpleCallback {
        void onSuccess(String message);
        void onError(String error);
    }

    public void getMaintenanceRequests(int userId, String userType, String status, String priority, String category, MaintenanceApiCallback callback) {
        String url = "http://192.168.101.6/BoardEase2/get_maintenance_requests.php" +
                "?user_id=" + userId +
                "&user_type=" + userType +
                "&status=" + status +
                "&priority=" + priority +
                "&category=" + category;
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        List<MaintenanceModel> requests = new ArrayList<>();
                        JSONArray requestsArray = response.getJSONArray("maintenance_requests");
                        for (int i = 0; i < requestsArray.length(); i++) {
                            JSONObject requestObj = requestsArray.getJSONObject(i);
                            MaintenanceModel maintenance = new MaintenanceModel();
                            maintenance.setId(requestObj.getInt("id"));
                            maintenance.setTitle(requestObj.getString("title"));
                            maintenance.setDescription(requestObj.getString("description"));
                            maintenance.setStatus(requestObj.getString("status"));
                            maintenance.setPriority(requestObj.getString("priority"));
                            requests.add(maintenance);
                        }
                        callback.onSuccess(requests);
                    } catch (JSONException e) {
                        callback.onError("Error parsing maintenance requests: " + e.getMessage());
                    }
                },
                error -> callback.onError("Network error: " + error.getMessage()));
        
        requestQueue.add(request);
    }

    public void updateMaintenanceStatus(int requestId, String newStatus, String notes, String assignedTo, String priority, String category, String estimatedCost, String completionDate, int userId, SimpleCallback callback) {
        String url = "http://192.168.101.6/BoardEase2/update_maintenance_status.php";
        
        JSONObject params = new JSONObject();
        try {
            params.put("request_id", requestId);
            params.put("new_status", newStatus);
            params.put("notes", notes);
            params.put("assigned_to", assignedTo);
            params.put("priority", priority);
            params.put("category", category);
            params.put("estimated_cost", estimatedCost);
            params.put("completion_date", completionDate);
            params.put("user_id", userId);
        } catch (JSONException e) {
            callback.onError("Error creating request parameters: " + e.getMessage());
            return;
        }
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, params,
                response -> {
                    try {
                        String message = response.getString("message");
                        callback.onSuccess(message);
                    } catch (JSONException e) {
                        callback.onError("Error parsing response: " + e.getMessage());
                    }
                },
                error -> callback.onError("Network error: " + error.getMessage()));
        
        requestQueue.add(request);
    }
}
