package com.gengroup.huy.gengo.View.LoginView;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;

import com.gengroup.huy.gengo.Common.Constant.Constant;
import com.gengroup.huy.gengo.Common.Validator.GenGoValidator;
import com.gengroup.huy.gengo.Component.RoundedButtonComponent;
import com.gengroup.huy.gengo.Component.RoundedPlainTextComponent;
import com.gengroup.huy.gengo.Model.User;
import com.gengroup.huy.gengo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity {

    GenGoValidator genGoValidator =new GenGoValidator();

    @BindView(R.id.edtAccount) RoundedPlainTextComponent edtAccount;
    @BindView(R.id.edtPassword) RoundedPlainTextComponent edtPassword;
    @BindView(R.id.btnLogin) RoundedButtonComponent btnLogin;
    @BindView(R.id.btnClear) RoundedButtonComponent btnClear;


    @OnTextChanged(value = R.id.edtAccount,callback = OnTextChanged.Callback.TEXT_CHANGED)
    public void checkValidateAccount(Editable editable){
        Log.d("CheckValidLength" , String.valueOf(genGoValidator.checkValidLength(editable.toString(), 3 , 14)));
        Boolean isValidLength = genGoValidator.checkValidLength(editable.toString(), Constant.MIN_LENGTH_ACCOUNT, Constant.MAX_LENGTH_ACCOUNT);
        Boolean isValidPattern = genGoValidator.checkValidPattern(editable.toString(),Constant.PATTERN_ACCOUNT);
        Log.d("CheckValidPattern" , isValidPattern.toString());
        if(isValidLength && isValidPattern){
            Log.d("Valid","true");
        } else {
            Log.d("Valid", "false");
        }
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
    }
}
