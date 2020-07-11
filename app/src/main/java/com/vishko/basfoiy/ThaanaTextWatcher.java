package com.vishko.basfoiy;

import android.text.Editable;
import android.text.TextWatcher;


public class ThaanaTextWatcher implements TextWatcher {

    // NOTE: it's a really bad idea to do modifications here, although it won't stutter
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    // NOTE: not super great to do it here either.
    public void beforeTextChanged(CharSequence s, int start, int count,int after) {}

    public void afterTextChanged(Editable s) {
        // we could use Transpose on the s as a string, but
        // the loop is more effective since we're dealing with an editable.
        for( int i = 0;i<s.toString().length(); i++ ) {
            char source = s.charAt(i);
            char ret = Thaanakeys.transposePhoneticSegha(s.charAt(i));
            if( source!=ret ) { //need to do this to prevent an infinite loop
                s.replace(i, i+1, Character.toString(ret));
            }
        }
    }
}
