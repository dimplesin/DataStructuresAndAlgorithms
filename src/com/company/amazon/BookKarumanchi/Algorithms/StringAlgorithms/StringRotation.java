package com.company.amazon.BookKarumanchi.Algorithms.StringAlgorithms;

/**
 * Created by v-dsindhi on 11/26/15.
 */
public class StringRotation {

    public boolean isRotation(String input1, String input2) {
        boolean isRotated = false;
        int i = 0, j = 0, count = input1.length();

        if (input1.length() != input2.length())
            return false;

        while (count != 0) {

            if (i == input1.length() && !isRotated) {
                isRotated = true;
                i = 0;
            }

            if (input1.charAt(i) == input2.charAt(j)) {
                i++;
                j++;
                count--;
            }

            else {
                if (isRotated) {
                    break;
                }
                if (i == input1.length() - 1 && !isRotated) {
                    isRotated = true;
                }
                if (i < input1.length()) {
                    j = 0;
                    count = input1.length();

                }
            /* To handle the duplicates. This is the special case.
             * This occurs when input1 contains two duplicate elements placed side-by-side as "ll" in "hello" while
             * they may not be side-by-side in input2 such as "lohel" but are still valid rotations.
             Eg: "hello" "lohel"
            */
                if (input1.charAt(i) == input2.charAt(j)) {
                    i--;
                }
                i++;
            }
        }
        if (count == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new StringRotation().isRotation("harry potter",
                "terharry pot"));
        System.out.println(new StringRotation().isRotation("hello", "llohe"));
        System.out.println(new StringRotation().isRotation("hello", "lohell"));
        System.out.println(new StringRotation().isRotation("hello", "hello"));
        System.out.println(new StringRotation().isRotation("hello", "lohe"));
    }
}
