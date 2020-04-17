package com.example.demo_corona.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo_corona.R;
import com.example.demo_corona.View.Activity.Model.Pref_Config;
import com.example.demo_corona.View.Retrofit.ApiClient;
import com.example.demo_corona.View.Retrofit.ApiInterface;

public class HomeActivity extends AppCompatActivity {

    private TextView userNameTV;
    private Button logOut;
    public static Pref_Config pref_config;
    public static ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inItView();
        pref_config = new Pref_Config(HomeActivity.this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        userNameTV.setText("WELCOME "+ pref_config.readName());

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref_config.writeLogInStatus(false);
                pref_config.writeName("User");
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void inItView() {
        userNameTV = findViewById(R.id.userNameView);
        logOut = findViewById(R.id.logOutBT);
    }
}
