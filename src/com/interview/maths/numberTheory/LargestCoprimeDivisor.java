package com.interview.maths.numberTheory;

import java.util.ArrayList;
import java.util.List;

public class LargestCoprimeDivisor {
    public static void main(String[] args){
        System.out.println(cpFact(88,2));
    }
    public static int cpFact(int A, int B) {
        List<Integer> fact = new ArrayList<>();
        int maxFact=(int)Math.sqrt(B);
        for(int i=2;i<=maxFact+1;i++){
            if(B%i==0){
                fact.add(i);
            }
        }

        System.out.println(fact);
        while(A%B==0){
            A=A/B;
        }
        for(int val:fact){
            while(A%val==0){
                A=A/val;
            }
        }
        return A;
    }
}
