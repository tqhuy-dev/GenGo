package com.gengroup.huy.gengo.Common.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by
 * Huy on 2/5/2019.
 */

public class GenGoValidator {
    public Boolean checkValidLength(String text,int minLenght , int maxLength){
        return text.length() > minLenght && text.length() < maxLength;
    }

    public Boolean checkValidPattern(String text , String pattern){
        Pattern patternCheck = Pattern.compile(pattern);
        Matcher matcher = patternCheck.matcher(text);
        return matcher.matches();
    }
}
