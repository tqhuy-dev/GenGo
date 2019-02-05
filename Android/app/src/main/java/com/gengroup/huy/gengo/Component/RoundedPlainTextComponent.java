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

import com.gengroup.huy.gengo.R;

/**
 * Created by
 * Huy on 1/31/2019.
 */

public class RoundedPlainTextComponent extends AppCompatEditText {
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
}
