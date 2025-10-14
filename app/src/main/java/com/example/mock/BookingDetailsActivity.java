package com.example.mock;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BookingDetailsActivity extends AppCompatActivity {
    
    private TextView bookingIdText;
    private TextView boarderNameText;
    private TextView roomDetailsText;
    private TextView statusText;
    private TextView dateText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        
        // Initialize views
        bookingIdText = findViewById(R.id.booking_id);
        boarderNameText = findViewById(R.id.boarder_name);
        roomDetailsText = findViewById(R.id.room_details);
        statusText = findViewById(R.id.booking_status);
        dateText = findViewById(R.id.booking_date);
        
        // Get booking details from intent
        String bookingId = getIntent().getStringExtra("booking_id");
        String boarderName = getIntent().getStringExtra("boarder_name");
        String roomDetails = getIntent().getStringExtra("room_details");
        String status = getIntent().getStringExtra("status");
        String date = getIntent().getStringExtra("date");
        
        // Set the data
        if (bookingId != null) bookingIdText.setText("Booking ID: " + bookingId);
        if (boarderName != null) boarderNameText.setText("Boarder: " + boarderName);
        if (roomDetails != null) roomDetailsText.setText("Room: " + roomDetails);
        if (status != null) statusText.setText("Status: " + status);
        if (date != null) dateText.setText("Date: " + date);
    }
}
