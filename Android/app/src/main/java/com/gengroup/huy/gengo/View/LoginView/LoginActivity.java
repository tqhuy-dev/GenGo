package com.gengroup.huy.gengo.View.LoginView;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;

import com.gengroup.huy.gengo.Api.ApiClient;
import com.gengroup.huy.gengo.Api.Body.LoginBody;
import com.gengroup.huy.gengo.Api.GenGoServices;
import com.gengroup.huy.gengo.Api.Response.BaseResponse;
import com.gengroup.huy.gengo.Common.Constant.Constant;
import com.gengroup.huy.gengo.Common.Validator.GenGoValidator;
import com.gengroup.huy.gengo.Component.RoundedButtonComponent;
import com.gengroup.huy.gengo.Component.RoundedPlainTextComponent;
import com.gengroup.huy.gengo.Model.User;
import com.gengroup.huy.gengo.R;
import com.gengroup.huy.gengo.View.SigninView.SigninActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    GenGoValidator genGoValidator =new GenGoValidator();
    GenGoServices genGoServices;

    @BindView(R.id.edtAccount) RoundedPlainTextComponent edtAccount;
    @BindView(R.id.edtPassword) RoundedPlainTextComponent edtPassword;
    @BindView(R.id.btnLogin) RoundedButtonComponent btnLogin;
    @BindView(R.id.btnClear) RoundedButtonComponent btnClear;

    @OnClick(R.id.btnLogin)
    public void Login(){
        Call<BaseResponse> call = genGoServices.login(new LoginBody(edtAccount.getText().toString(),edtPassword.getText().toString()));
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                Log.d("response" , response.body().message);
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                Log.d("response" , t.toString());
            }
        });
    }

    @OnClick(R.id.tvLinkToSignin)
    public void MoveToSignInForm(){
        Intent intent =new Intent(LoginActivity.this , SigninActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnClear)
    public void clearAllDataTextView(){
        edtAccount.setText("");
        edtPassword.setText("");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnTextChanged(value = {R.id.edtAccount , R.id.edtPassword},callback = OnTextChanged.Callback.TEXT_CHANGED)
    public void checkValidate(Editable editable){
        Boolean isValidLengthAccount = genGoValidator.checkValidLength(editable.toString(), Constant.MIN_LENGTH_ACCOUNT, Constant.MAX_LENGTH_ACCOUNT);
        Boolean isValidPatternAccount = genGoValidator.checkValidPattern(editable.toString(),Constant.PATTERN_ACCOUNT);
        Boolean isValidLengthPassword = genGoValidator.checkValidLength(editable.toString(),Constant.MIN_LENGTH_PASSWORD,Constant.MAX_LENGTH_PASSWORD);
        this.setEnableButtonLogin(isValidLengthAccount && isValidPatternAccount && isValidLengthPassword);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        LoginViewModel model = ViewModelProviders.of(this).get(LoginViewModel.class);
        model.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                edtAccount.setText(user.getAccount());
                edtPassword.setText(user.getPassword());
            }
        });
        genGoServices= ApiClient.getClient().create(GenGoServices.class);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void setEnableButtonLogin(boolean isEnable){
        this.btnLogin.setEnabled(isEnable);
        Drawable drawable = null;
        if(isEnable){
            drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.background_button_rounded,null);
        }
        else {
            drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.background_button_disabled_rounded,null);
        }
        this.btnLogin.setBackground(drawable);
    }
}
