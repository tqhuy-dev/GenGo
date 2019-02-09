package com.gengroup.huy.gengo.Component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;

import com.gengroup.huy.gengo.Model.PatternValid;
import com.gengroup.huy.gengo.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by
 * Huy on 1/31/2019.
 */

public class RoundedPlainTextComponent extends AppCompatEditText {
    private PatternValid patternValid ;
    public RoundedPlainTextComponent(Context context) {
        super(context);
    }

    public RoundedPlainTextComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedPlainTextComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        super.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/opensans_bold.ttf"));
    }

    public void setPatternValid(PatternValid patternValid) {
        this.patternValid = patternValid;
    }

    public Boolean checkValidPattern(String text , String pattern){
        Pattern patternCheck = Pattern.compile(pattern);
        Matcher matcher = patternCheck.matcher(text);
        return matcher.matches();
    }

    public Boolean checkValidAll(){
        if(patternValid.getPatternRegEx() != null && !(this.checkValidPattern(this.getText().toString() , patternValid.getPatternRegEx()))){
            return false;
        } else
        if(patternValid.getMaxLength() != 0 && (this.getText().length() > patternValid.getMaxLength())){
            return false;
        } else
        if(patternValid.getMinLength() != 0 && this.getText().length() < patternValid.getMinLength()){
            return false;
        }
        return true;
    }
}
