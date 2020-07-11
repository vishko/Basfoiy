package com.vishko.basfoiy;

import android.text.InputFilter;
import android.text.Spanned;


public class ThaanaInputFilter implements InputFilter {

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        CharSequence converted = Thaanakeys.transposePhoneticSegha(source);
        if(converted.equals(source))
            return null;
        else
            return converted;
    }
}
