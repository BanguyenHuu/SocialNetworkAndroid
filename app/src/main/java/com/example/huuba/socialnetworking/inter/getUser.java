package com.example.huuba.socialnetworking.inter;

import com.example.huuba.socialnetworking.model.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface getUser {
    @GET("auth/getuser")
    Call<UserResponse> getuser(@Query("username") String username);
}
