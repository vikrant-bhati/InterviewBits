package com.interview.maths.numberTheory;

public class GreatestCommonDivisor {

    public static void main(String[] args){
        System.out.println(gcd(114,672));
    }
    public static int gcd(int A, int B) {
        if(A==0 || B==0){
            return Math.max(A,B);
        }
        else if(A%B==0 || B%A==0){
            return Math.min(A,B);
        }
        int ans=1;
        int div = Math.min(A,B);
        int divs=Math.max(A,B);
        while(div>=1){
            if(divs%div==0){
                ans=div;
                break;
            }else{
                int temp=divs%div;
                divs=div;
                div=temp;

            }
        }
        return ans;
    }
}
