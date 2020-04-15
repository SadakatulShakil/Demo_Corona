package com.example.demo_corona.View.Retrofit;

import com.example.demo_corona.View.Activity.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("register.php")
    Call<User> performRegistration(@Query("User_email") String Email,
                                   @Query("User_name") String Name,
                                   @Query("User_password") String Password);

    @GET("login.php")
    Call<User> performUserLogin( @Query("User_name") String Name,
                                 @Query("User_password") String Password);
}
