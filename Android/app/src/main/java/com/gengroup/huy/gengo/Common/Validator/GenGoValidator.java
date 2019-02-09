package com.gengroup.huy.gengo.Common.Validator;

import com.gengroup.huy.gengo.Model.PatternValid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by
 * Huy on 2/5/2019.
 */

public class GenGoValidator {
    public Boolean checkValidLength(String text,int minLength , int maxLength){
        return text.length() > minLength && text.length() < maxLength;
    }

    public Boolean checkValidPattern(String text , String pattern){
        Pattern patternCheck = Pattern.compile(pattern);
        Matcher matcher = patternCheck.matcher(text);
        return matcher.matches();
    }

}
