package com.interview.maths.baseNumberSystem;

public class ExcelColumnNumber {
    public static void main(String[] args){

        System.out.println(titleToNumber("ABA"));
    }
    public static int titleToNumber(String A) {
        int sum=0;
        int initial='A';
        for(int i=A.length()-1;i>=0;i--){
            sum+=(A.charAt(i)-initial+1)*Math.pow(26,A.length()-1-i);
        }
        return sum;

    }
}
