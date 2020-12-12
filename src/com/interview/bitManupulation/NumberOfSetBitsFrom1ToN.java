package com.interview.bitManupulation;

public class NumberOfSetBitsFrom1ToN {

    public static void main(String[] args){
        for(int i=0;i<=15;i++)
        System.out.println(count(i+1));
    }

    public static long count(int number){
       //  System.out.println("number: "+number);
        if(number ==0){
            return 0;
        }

        int count=0;
        while(number>=(1<<count)){
           count++;
       }

        int val=1<<(--count);
       // System.out.println("val: "+val);
        // System.out.println("count: "+count);
        long ans=(count*val/2)+(number-val)+count(number-val);
        // System.out.println(number + " val "+ans);
        return ans;
    }

}
