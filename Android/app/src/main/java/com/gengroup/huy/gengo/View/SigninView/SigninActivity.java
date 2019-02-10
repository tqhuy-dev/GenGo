package com.gengroup.huy.gengo.View.SigninView;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gengroup.huy.gengo.Api.ApiClient;
import com.gengroup.huy.gengo.Api.Body.SigninBody;
import com.gengroup.huy.gengo.Api.GenGoServices;
import com.gengroup.huy.gengo.Api.Response.BaseResponse;
import com.gengroup.huy.gengo.Common.Constant.Constant;
import com.gengroup.huy.gengo.Component.RoundedButtonComponent;
import com.gengroup.huy.gengo.Component.RoundedPlainTextComponent;
import com.gengroup.huy.gengo.Model.PatternValid;
import com.gengroup.huy.gengo.R;
import com.gengroup.huy.gengo.View.LoginView.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninActivity extends AppCompatActivity {
    private GenGoServices genGoServices;

    @BindView(R.id.edtAccount) RoundedPlainTextComponent edtAccount;
    @BindView(R.id.edtPassword) RoundedPlainTextComponent edtPassword;
    @BindView(R.id.edtConfirmPassword) RoundedPlainTextComponent edtConfirmPassword;
    @BindView(R.id.edtFirstName) RoundedPlainTextComponent edtFirstName;
    @BindView(R.id.edtLastName) RoundedPlainTextComponent edtLastName;

    @BindView(R.id.btnSignin) RoundedButtonComponent btnSignin;
    @BindView(R.id.btnBackLogin) RoundedButtonComponent btnBackLogin;

    @OnClick(R.id.btnSignin)
    public void Signin(){
        if(checkValidation()){
            Call <BaseResponse> call = genGoServices.signin(
                    new SigninBody(edtAccount.getText().toString(),
                                   edtPassword.getText().toString(),
                                   edtFirstName.getText().toString(),
                                   edtLastName.getText().toString()));

            call.enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                    Log.d("response" , response.body().message);
                }

                @Override
                public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                    Log.d("error" , t.toString());
                }
            });
        } else {
            Toast.makeText(SigninActivity.this , "Error" , Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnBackLogin)
    public void BackToLoginActivity(){
        Intent intent = new Intent(SigninActivity.this , LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);
        setValidationEditText();
        genGoServices= ApiClient.getClient().create(GenGoServices.class);
    }

    private void setValidationEditText(){
        this.edtFirstName.setPatternValid(new PatternValid(Constant.PATTERN_NAME,0 , 1));
        this.edtLastName.setPatternValid(new PatternValid(Constant.PATTERN_NAME , 0 ,1));
        this.edtAccount.setPatternValid(new PatternValid(Constant.PATTERN_ACCOUNT , 20 ,5));
        this.edtPassword.setPatternValid(new PatternValid(null,40,10));
    }

    private Boolean checkValidation(){
        return (this.edtAccount.checkValidAll() && this.edtPassword.checkValidAll()
                && this.edtLastName.checkValidAll() && this.edtFirstName.checkValidAll()
                && this.edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString()));
    }
}
