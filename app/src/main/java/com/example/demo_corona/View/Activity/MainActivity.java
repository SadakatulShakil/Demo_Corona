package com.example.demo_corona.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo_corona.R;
import com.example.demo_corona.View.Activity.Model.Pref_Config;
import com.example.demo_corona.View.Activity.Model.User;
import com.example.demo_corona.View.Retrofit.ApiClient;
import com.example.demo_corona.View.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText user_name, user_Password;
    private Button signIn;
    private TextView signUp;
    public static Pref_Config pref_config;
    public static ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref_config = new Pref_Config(MainActivity.this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        inItView();


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    }

    private void performLogin() {

        final String name = user_name.getText().toString().trim();
        String password = user_Password.getText().toString().trim();

        Call<User> call = MainActivity.apiInterface.performUserLogin(name, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body().getResponse().equals("ok")){
                    Toast.makeText(MainActivity.this, "Success......", Toast.LENGTH_SHORT).show();
                    MainActivity.pref_config.writeLogInStatus(true);
                    MainActivity.pref_config.writeName(name);
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(response.body().getResponse().equals("Failed")){
                    Toast.makeText(MainActivity.this, "Log in failed......", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        user_name.setText("");
        user_Password.setText("");
    }

    private void inItView() {
        user_name = findViewById(R.id.userNameET);
        user_Password =findViewById(R.id.passwordET);
        signIn = findViewById(R.id.signInBT);
        signUp = findViewById(R.id.signUpBt);
    }
}
