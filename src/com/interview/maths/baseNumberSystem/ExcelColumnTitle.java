package com.interview.maths.baseNumberSystem;

import java.util.ArrayList;

public class ExcelColumnTitle {
public static void main(String[] args){
   System.out.println(convertToTitle(943566));
    // for(int i=1;i<=27;i++)
   // System.out.println(convertToTitle(i));


}
    public static String convertToTitle(int A) {
        if (A <= 1) {
            return "A";

        }
        StringBuilder str = new StringBuilder();
        int initial = 'A';
        while (A > 0) {
            char rem;
            if (A % 26 == 0) {
                rem = 'Z';
                A = A - 26;
            } else {
                rem = (char) (initial + (A % 26) - 1);
            }
            str.append(rem);
            A = A / 26;
        }

        return str.reverse().toString();
    }

}
