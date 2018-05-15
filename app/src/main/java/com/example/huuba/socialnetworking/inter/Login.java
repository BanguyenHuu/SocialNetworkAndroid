package com.example.huuba.socialnetworking.inter;

import com.example.huuba.socialnetworking.model.request.LoginRequest;
import com.example.huuba.socialnetworking.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Login {
    @POST("auth/login")
    Call<LoginResponse> login(@Body LoginRequest request);
}
