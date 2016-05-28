package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/8/15.
 */
public class ImplementIntegerParseInt {

    public static int parseInt(String s, int radix)
            throws NumberFormatException
    {
        /*
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         */

        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    throw new NumberFormatException();

                if (len == 1) // Cannot have lone "+" or "-"
                    throw new NumberFormatException();
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    throw new NumberFormatException();
                }
                if (result < multmin) {
                    throw new NumberFormatException();
                }
                result *= radix;
                if (result < limit + digit) {
                    throw new NumberFormatException();
                }
                result -= digit;
            }
        } else {
            throw new NumberFormatException();
        }
        return negative ? result : -result;
    }


    public static void ImplementParseInt(String str) {
        int sum = 0;
        char[] array = str.toCharArray();
        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            sum += Math.pow(10, j) * (array[i] - '0');
            j++;
        }System.out.println(sum);
    }

    public static void stringValueOf(int value){
            if (value == 0) System.out.println("0");
            if (value == Integer.MIN_VALUE) System.out.println("-2147483648");

            final boolean negative = value < 0;
            if (negative) value = -value;

            final StringBuilder buf = new StringBuilder();
            while (value != 0) {
                int digit = value % 10;
                buf.append( (char)(0x30 + digit) );
                value = value / 10;
            }
            if (negative) buf.append('-');

            System.out.println(buf.reverse().toString());
        }

    public static void main(String args[]){
        String str= "12345";
        ImplementParseInt(str);
        stringValueOf(Integer.parseInt(str));
    }
}
