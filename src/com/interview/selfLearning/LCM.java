package com.interview.selfLearning;
//To find the LCM we can find the greatest common divisor, Divide one number with GCD
// multiple it with second number
public class LCM {
    public static void main(String[] args){
System.out.println("ans is: "+LCM(4,23));
    }
    public static int LCM(int A, int B){
    return ((A/GCD(A,B) )* B);
    }

    public static int GCD(int A, int B){
        if(A==0){
            return B;
        }
         return  GCD(B%A,A);

    }
}
