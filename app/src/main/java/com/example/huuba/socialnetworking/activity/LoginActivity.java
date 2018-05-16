package com.example.huuba.socialnetworking.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.huuba.socialnetworking.Constants;
import com.example.huuba.socialnetworking.R;
import com.example.huuba.socialnetworking.inter.Login;
import com.example.huuba.socialnetworking.inter.getUser;
import com.example.huuba.socialnetworking.model.request.LoginRequest;
import com.example.huuba.socialnetworking.model.response.LoginResponse;
import com.example.huuba.socialnetworking.model.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername;
    private EditText edtPass;
    private Button btnLogin;
    private Button btnRegister;
    private TextView tvForgotPass;
    private String username;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        edtUsername = (EditText) findViewById(R.id.username_log);
        edtPass = (EditText) findViewById(R.id.password_log);
        btnRegister = (Button) findViewById(R.id.register_log);
        btnLogin = (Button) findViewById(R.id.login_log);
        tvForgotPass = (TextView) findViewById(R.id.forgot);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        tvForgotPass.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_log:
                        Intent intent=new Intent();
                        intent.setClassName(LoginActivity.this, RegisterActivity.class.getName());
                        startActivity(intent);
                        finish();
                break;
            case R.id.login_log:
                getIf("huuba");
                //login();
                break;
        }
    }
    private void login(){
         this.username=edtUsername.getText().toString();
        String pasword=edtPass.getText().toString();
        LoginRequest request=new LoginRequest(username,pasword);
        final Login login=
        new Retrofit.Builder().baseUrl(Constants.baseUrl).addConverterFactory(GsonConverterFactory.create()).
                build().create(Login.class);
        Call<LoginResponse> call=login.login(request);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse=response.body();
                if( loginResponse != null &&
                        loginResponse.getStatusCode() == 0) {
                    Log.d("cc","sucess"+loginResponse.getData().getToken());
//                    Intent intent = new Intent();
//                    intent.setClass(LoginActivity.this,
//                            MainActivity.class);
//                    intent.putExtra("TOKEN", loginResponse.getData().getToken());//??? lấy token từ db
//                    intent.putExtra("USERNAME",username);
//                    startActivity(intent);
//                    finish();
                }
                else {
                    Log.d("tesst","user name or passwored incorrect");
                }
        }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
            }
        });

    }
    private void getIf(String username){
        getUser detailUser=
        new Retrofit.Builder().baseUrl(Constants.baseUrl).addConverterFactory(GsonConverterFactory.create()).
                build().create(getUser.class);
        Call<UserResponse> call=detailUser.getuser(username);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse=response.body();
                if(userResponse!=null && userResponse.getStatusCode()==0){
                    Log.d("cc",userResponse.getData().getToken());
                }
                else {
                    Log.d("error","nothing"+userResponse.getMsg());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("error",t.getMessage());

            }
        });

    }
}
