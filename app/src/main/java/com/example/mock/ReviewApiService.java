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

public class ReviewApiService {
    private Context context;
    private RequestQueue requestQueue;

    public ReviewApiService(Context context) {
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public interface ReviewApiCallback {
        void onSuccess(List<ReviewModel> reviews);
        void onError(String error);
    }

    public void getReviews(int boardingHouseId, int userId, int page, String filter, String status, String sortBy, ReviewApiCallback callback) {
        String url = "http://192.168.101.6/BoardEase2/get_reviews.php" +
                "?boarding_house_id=" + boardingHouseId +
                "&user_id=" + userId +
                "&page=" + page +
                "&filter=" + filter +
                "&status=" + status +
                "&sort_by=" + sortBy;
        
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        List<ReviewModel> reviews = new ArrayList<>();
                        JSONArray reviewsArray = response.getJSONArray("reviews");
                        for (int i = 0; i < reviewsArray.length(); i++) {
                            JSONObject reviewObj = reviewsArray.getJSONObject(i);
                            ReviewModel review = new ReviewModel();
                            review.setId(reviewObj.getInt("id"));
                            review.setRating(reviewObj.getInt("rating"));
                            review.setComment(reviewObj.getString("comment"));
                            review.setDate(reviewObj.getString("date"));
                            review.setReviewerName(reviewObj.getString("reviewer_name"));
                            reviews.add(review);
                        }
                        callback.onSuccess(reviews);
                    } catch (JSONException e) {
                        callback.onError("Error parsing reviews: " + e.getMessage());
                    }
                },
                error -> callback.onError("Network error: " + error.getMessage()));
        
        requestQueue.add(request);
    }
}
