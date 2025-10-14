package com.example.mock;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateGroupChat extends AppCompatActivity {
    
    private EditText groupNameEditText;
    private EditText groupDescriptionEditText;
    private Button createGroupButton;
    private Button cancelButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group_chat);
        
        // Initialize views
        groupNameEditText = findViewById(R.id.group_name);
        groupDescriptionEditText = findViewById(R.id.group_description);
        createGroupButton = findViewById(R.id.create_group_button);
        cancelButton = findViewById(R.id.cancel_button);
        
        // Set up button listeners
        createGroupButton.setOnClickListener(v -> {
            String groupName = groupNameEditText.getText().toString().trim();
            String groupDescription = groupDescriptionEditText.getText().toString().trim();
            
            if (groupName.isEmpty()) {
                Toast.makeText(this, "Please enter a group name", Toast.LENGTH_SHORT).show();
                return;
            }
            
            // TODO: Implement group creation logic
            Toast.makeText(this, "Group created: " + groupName, Toast.LENGTH_SHORT).show();
            finish();
        });
        
        cancelButton.setOnClickListener(v -> finish());
    }
}
