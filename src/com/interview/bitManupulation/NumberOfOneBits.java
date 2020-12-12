package com.interview.bitManupulation;

public class NumberOfOneBits {

    public static void main(String[] args){
        int x = 0B00000000000000000000000000001011;
        int count=0;
        while(x!=0){
            x=x&(x-1);
            count++;

        }
        System.out.println(count);
    }
}
