package com.interview.selfLearning;

public class understandingModulo {
    public static final int mod = 1000003;
    public static void main(String[] args){
       int[] valMap={8 , 8 , 7 };
        long[] fact = new long[24];
        fact[0]=1;
        for(int i=1;i<24;i++){
            fact[i]=fact[i-1]*i;
        }
        long d=1L;
        for(int val:valMap){
            d=(d*fact[val])%mod;
        }
        System.out.println(d);
    }
}
