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

public class BoarderApiService {
    private Context context;
    private RequestQueue requestQueue;

    public BoarderApiService(Context context) {
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public interface BoarderApiCallback {
        void onSuccess(List<BoarderModel> boarders);
        void onError(String error);
    }

    public interface BoarderHistoryApiCallback {
        void onSuccess(List<BoarderModel> boarders);
        void onError(String error);
    }

    public void getCurrentBoarders(int userId, BoarderApiCallback callback) {
        String url = "http://192.168.101.6/BoardEase2/get_current_boarders.php?user_id=" + userId;
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        List<BoarderModel> boarders = new ArrayList<>();
                        JSONArray boardersArray = response.getJSONArray("boarders");
                        for (int i = 0; i < boardersArray.length(); i++) {
                            JSONObject boarderObj = boardersArray.getJSONObject(i);
                            BoarderModel boarder = new BoarderModel();
                            boarder.setId(boarderObj.getInt("id"));
                            boarder.setName(boarderObj.getString("name"));
                            boarder.setEmail(boarderObj.getString("email"));
                            boarder.setPhone(boarderObj.getString("phone"));
                            boarders.add(boarder);
                        }
                        callback.onSuccess(boarders);
                    } catch (JSONException e) {
                        callback.onError("Error parsing boarders: " + e.getMessage());
                    }
                },
                error -> callback.onError("Network error: " + error.getMessage()));
        
        requestQueue.add(request);
    }

    public void getBoardersHistory(int userId, BoarderHistoryApiCallback callback) {
        String url = "http://192.168.101.6/BoardEase2/get_boarders_history.php?user_id=" + userId;
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        List<BoarderModel> boarders = new ArrayList<>();
                        JSONArray boardersArray = response.getJSONArray("boarders");
                        for (int i = 0; i < boardersArray.length(); i++) {
                            JSONObject boarderObj = boardersArray.getJSONObject(i);
                            BoarderModel boarder = new BoarderModel();
                            boarder.setId(boarderObj.getInt("id"));
                            boarder.setName(boarderObj.getString("name"));
                            boarder.setEmail(boarderObj.getString("email"));
                            boarder.setPhone(boarderObj.getString("phone"));
                            boarders.add(boarder);
                        }
                        callback.onSuccess(boarders);
                    } catch (JSONException e) {
                        callback.onError("Error parsing boarders: " + e.getMessage());
                    }
                },
                error -> callback.onError("Network error: " + error.getMessage()));
        
        requestQueue.add(request);
    }
}
