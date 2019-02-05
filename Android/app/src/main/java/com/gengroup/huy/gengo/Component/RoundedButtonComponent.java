package com.gengroup.huy.gengo.Component;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by
 * Huy on 1/31/2019.
 */

public class RoundedButtonComponent extends AppCompatButton {
    public RoundedButtonComponent(Context context) {
        super(context);
    }

    public RoundedButtonComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedButtonComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {

        super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/opensans_bold.ttf"), style);
    }
}
