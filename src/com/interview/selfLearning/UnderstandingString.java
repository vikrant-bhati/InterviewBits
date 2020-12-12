package com.interview.selfLearning;

import java.util.Arrays;

public class UnderstandingString {

    public static void main(String[] args){
        String s="abb";
        System.out.println(s.substring(0,3));

        String test="123.";
        System.out.println(Arrays.toString(test.split("\\.")));
    }
}
