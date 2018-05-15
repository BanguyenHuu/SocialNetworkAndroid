package com.example.huuba.socialnetworking.inter;

import com.example.huuba.socialnetworking.model.request.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Register {
    @POST("auth/register")
    Call<RegisterRequest> register(@Body RegisterRequest registerRequest);

}
