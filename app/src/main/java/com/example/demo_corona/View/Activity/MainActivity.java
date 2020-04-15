package com.example.demo_corona.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demo_corona.R;

public class MainActivity extends AppCompatActivity {

    private EditText user_name, user_Password;
    private Button signIn;
    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inItView();
    }

    private void inItView() {
        user_name = findViewById(R.id.userNameET);
        user_Password =findViewById(R.id.passwordET);
        signIn = findViewById(R.id.signInBT);
        signUp = findViewById(R.id.signUpBt);
    }
}
