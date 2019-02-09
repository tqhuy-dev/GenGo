package com.gengroup.huy.gengo.View.SigninView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gengroup.huy.gengo.Common.Constant.Constant;
import com.gengroup.huy.gengo.Component.RoundedButtonComponent;
import com.gengroup.huy.gengo.Component.RoundedPlainTextComponent;
import com.gengroup.huy.gengo.Model.PatternValid;
import com.gengroup.huy.gengo.R;
import com.gengroup.huy.gengo.View.LoginView.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SigninActivity extends AppCompatActivity {

    @BindView(R.id.edtAccount) RoundedPlainTextComponent edtAccount;
    @BindView(R.id.edtPassword) RoundedPlainTextComponent edtPassword;
    @BindView(R.id.edtConfirmPassword) RoundedPlainTextComponent edtConfirmPassword;
    @BindView(R.id.edtFirstName) RoundedPlainTextComponent edtFirstName;
    @BindView(R.id.edtLastName) RoundedPlainTextComponent edtLastName;

    @BindView(R.id.btnSignin) RoundedButtonComponent btnSignin;
    @BindView(R.id.btnBackLogin) RoundedButtonComponent btnBackLogin;

    @OnClick(R.id.btnSignin)
    public void Signin(){
        Log.d("Status" , String.valueOf(checkValidation()));
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
    }

    private void setValidationEditText(){
        this.edtFirstName.setPatternValid(new PatternValid(Constant.PATTERN_NAME,0 , 1));
        this.edtLastName.setPatternValid(new PatternValid(Constant.PATTERN_NAME , 0 ,1));
        this.edtAccount.setPatternValid(new PatternValid(Constant.PATTERN_ACCOUNT , 20 ,5));
        this.edtPassword.setPatternValid(new PatternValid(null,40,10));
    }

    private Boolean checkValidation(){
        return (this.edtAccount.checkValidAll() && this.edtPassword.checkValidAll()
                && this.edtLastName.checkValidAll() && this.edtFirstName.checkValidAll());
    }
}
