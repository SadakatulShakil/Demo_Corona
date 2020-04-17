package com.example.demo_corona.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo_corona.R;
import com.example.demo_corona.View.Activity.Model.Pref_Config;
import com.example.demo_corona.View.Activity.Model.User;
import com.example.demo_corona.View.Retrofit.ApiClient;
import com.example.demo_corona.View.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private EditText user_Name, user_Email, user_Password;
    private Button signUp;
    public static Pref_Config pref_config;
    public static ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inItView();
        pref_config = new Pref_Config(SignUpActivity.this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });
    }

    private void performRegistration() {
        String name = user_Name.getText().toString().trim();
        String email = user_Email.getText().toString().trim();
        String password = user_Password.getText().toString().trim();

        Call<User> call = SignUpActivity.apiInterface.performRegistration(email, name, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body().getResponse().equals("ok")){
                    Toast.makeText(SignUpActivity.this, "Success......", Toast.LENGTH_SHORT).show();
                }
                else if(response.body().getResponse().equals("exist")){
                    Toast.makeText(SignUpActivity.this, "User Exist......", Toast.LENGTH_SHORT).show();
                }
                else if(response.body().getResponse().equals("error")){
                    Toast.makeText(SignUpActivity.this, "Something Error......", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        user_Name.setText("");
        user_Email.setText("");
        user_Password.setText("");
    }

    private void inItView() {
        user_Name = findViewById(R.id.userNameET);
        user_Email = findViewById(R.id.userEmailET);
        user_Password =findViewById(R.id.passwordET);
        signUp = findViewById(R.id.signUpBT);
    }
}
