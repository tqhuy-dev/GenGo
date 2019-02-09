package com.gengroup.huy.gengo.Model;

/**
 * Created by
 * Huy on 2/9/2019.
 */

public class PatternValid {
    private String PatternRegEx  = "";
    private int MaxLength = 0;
    private int MinLength = 0;

    public PatternValid(String patternRegEx, int max, int min) {
        PatternRegEx = patternRegEx;
        this.MaxLength = max;
        this.MinLength = min;
        if(max < min && max != 0 && min != 0){
            this.MaxLength = min;
            this.MinLength =  max;
        }
    }

    public String getPatternRegEx() {
        return PatternRegEx;
    }

    public int getMaxLength() {
        return MaxLength;
    }

    public int getMinLength() {
        return MinLength;
    }
}
