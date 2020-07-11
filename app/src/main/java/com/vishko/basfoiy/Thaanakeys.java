package com.vishko.basfoiy;


public class Thaanakeys {


    public static CharSequence transposePhoneticSegha(CharSequence s) {
        String transposed = s.toString();

        // loop through the string, and replace all instances
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char trans = transposePhoneticSegha(c);
            if (c == trans) continue;
            transposed = transposed.replace(c, trans);
        }

        return transposed;
    }


    public static char transposePhoneticSegha(char c) {

        switch (c) {
            //basic consonants
            case ',':
                return '،';
            case ';':
                return '؛';
            case '?':
                return '؟';
            case 'A':
                return 'ާ';
            case 'B':
                return 'ޞ';
            case 'C':
                return 'ޝ';
            case 'D':
                return 'ޑ';
            case 'E':
                return 'ޭ';
            case 'F':
                return 'ﷲ';
            case 'G':
                return 'ޣ';
            case 'H':
                return 'ޙ';
            case 'I':
                return 'ީ';
            case 'J':
                return 'ޛ';
            case 'K':
                return 'ޚ';
            case 'L':
                return 'ޅ';
            case 'M':
                return 'ޟ';
            case 'N':
                return 'ޏ';
            case 'O':
                return 'ޯ';
            case 'P':
                return '÷';
            case 'Q':
                return 'ޤ';
            case 'R':
                return 'ޜ';
            case 'S':
                return 'ށ';
            case 'T':
                return 'ޓ';
            case 'U':
                return 'ޫ';
            case 'V':
                return 'ޥ';
            case 'W':
                return 'ޢ';
            case 'X':
                return 'ޘ';
            case 'Y':
                return 'ޠ';
            case 'Z':
                return 'ޡ';
            case 'a':
                return 'ަ';
            case 'b':
                return 'ބ';
            case 'c':
                return 'ޗ';
            case 'd':
                return 'ދ';
            case 'e':
                return 'ެ';
            case 'f':
                return 'ފ';
            case 'g':
                return 'ގ';
            case 'h':
                return 'ހ';
            case 'i':
                return 'ި';
            case 'j':
                return 'ޖ';
            case 'k':
                return 'ކ';
            case 'l':
                return 'ލ';
            case 'm':
                return 'މ';
            case 'n':
                return 'ނ';
            case 'o':
                return 'ޮ';
            case 'p':
                return 'ޕ';
            case 'q':
                return 'ް';
            case 'r':
                return 'ރ';
            case 's':
                return 'ސ';
            case 't':
                return 'ތ';
            case 'u':
                return 'ު';
            case 'v':
                return 'ވ';
            case 'w':
                return 'އ';
            case 'x':
                return '×';
            case 'y':
                return 'ޔ';
            case 'z':
                return 'ޒ';
            case 'ñ':
                return 'ޱ';
            default:
                return c;

        }

    }

}
