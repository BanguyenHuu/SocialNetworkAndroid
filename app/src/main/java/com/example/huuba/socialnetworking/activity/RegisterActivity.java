package com.example.huuba.socialnetworking.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.huuba.socialnetworking.Constants;
import com.example.huuba.socialnetworking.R;
import com.example.huuba.socialnetworking.inter.Register;
import com.example.huuba.socialnetworking.model.request.RegisterRequest;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,Constants{
    private EditText edt_email;
    private EditText edt_username;
    private EditText edt_pass;
    private EditText edt_confirm;
    private Button btn_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.acvitity_register);
        init();
    }
    private void init() {
        edt_pass = (EditText) findViewById(R.id.password_rg);
        edt_username = (EditText) findViewById(R.id.username_rg);
        edt_email = (EditText) findViewById(R.id.email_rg);
        edt_confirm = (EditText) findViewById(R.id.confirm_rg);
        btn_register = (Button) findViewById(R.id.register_rg);
        btn_register.setOnClickListener(this);
    }
    private void register(){
        String email=edt_email.getText().toString();
        String username=edt_username.getText().toString();
        String pass=edt_pass.getText().toString();
        String confirm=edt_confirm.getText().toString();
        if(!Util.equal(confirm,pass)){
            //  Toast.makeText(RegisterActivity.this,"pasword not math").show();
            Toast.makeText(this,"passord not math", Toast.LENGTH_LONG).show();
        }
        else {
            RegisterRequest request=new RegisterRequest(email,username,pass);

            final Register register =
                    new Retrofit.Builder().baseUrl(Constants.baseUrl).addConverterFactory(GsonConverterFactory.create()).build().create(Register.class);

            Call<RegisterRequest> registerRequestCall=register.register(request);

            registerRequestCall.enqueue(new Callback<RegisterRequest>() {
                @Override
                public void onResponse(Call<RegisterRequest> call, Response<RegisterRequest> response) {
                    Log.d("ss","register  sucess");
                }

                @Override
                public void onFailure(Call<RegisterRequest> call, Throwable t) {
                    Log.d("ss","register don't sucess");
                    Log.d("error",t.getMessage());
                }
            });
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_rg:
                register();

        }

    }

}
