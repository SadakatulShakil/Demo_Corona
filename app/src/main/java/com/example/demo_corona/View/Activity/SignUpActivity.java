package com.example.demo_corona.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.demo_corona.R;

public class SignUpActivity extends AppCompatActivity {
    private EditText user_name, user_Email, user_Password;
    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inItView();

    }

    private void inItView() {
        user_name = findViewById(R.id.userNameET);
        user_Password =findViewById(R.id.passwordET);
        signUp = findViewById(R.id.signUpBT);
    }
}
