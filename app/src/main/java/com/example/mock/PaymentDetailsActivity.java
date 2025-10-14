package com.example.mock;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentDetailsActivity extends AppCompatActivity {
    
    private TextView paymentIdText;
    private TextView amountText;
    private TextView statusText;
    private TextView dateText;
    private TextView boarderNameText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        
        // Initialize views
        paymentIdText = findViewById(R.id.payment_id);
        amountText = findViewById(R.id.payment_amount);
        statusText = findViewById(R.id.payment_status);
        dateText = findViewById(R.id.payment_date);
        boarderNameText = findViewById(R.id.boarder_name);
        
        // Get payment details from intent
        String paymentId = getIntent().getStringExtra("payment_id");
        String amount = getIntent().getStringExtra("amount");
        String status = getIntent().getStringExtra("status");
        String date = getIntent().getStringExtra("date");
        String boarderName = getIntent().getStringExtra("boarder_name");
        
        // Set the data
        if (paymentId != null) paymentIdText.setText("Payment ID: " + paymentId);
        if (amount != null) amountText.setText("Amount: ₱" + amount);
        if (status != null) statusText.setText("Status: " + status);
        if (date != null) dateText.setText("Date: " + date);
        if (boarderName != null) boarderNameText.setText("Boarder: " + boarderName);
    }
}
