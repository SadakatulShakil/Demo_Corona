package com.example.demo_corona.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo_corona.R;

public class HomeActivity extends AppCompatActivity {

    private TextView userNameTV;
    private Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inItView();
    }

    private void inItView() {
        userNameTV = findViewById(R.id.userNameView);
        logOut = findViewById(R.id.logOutBT);
    }
}
