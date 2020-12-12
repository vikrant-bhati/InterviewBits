package com.interview.array.arrayMath;

import java.util.Arrays;

public class Flip {

    public static void main(String[] args){
        String A="0011101";
       int[] ans = flip(A);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] flip(String A) {
        char[] arr = A.toCharArray();
        int[] B = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1'){
                B[i]=-1;
            }else{
                B[i]=1;
            }
        }
        int[] ans = new int[2];
        int maximumSum=0;
        int start_min=0;
        int start=0;
        int end=0;
        int maximumSoFar=0;
        boolean starting=true;
        for(int i=0;i<B.length;i++){
            maximumSum+=B[i];
            if(maximumSum>0 && starting){
                start_min=i;
                starting=false;
            }
            if(maximumSum>maximumSoFar){
                start=start_min;
                end=i;
                maximumSoFar=maximumSum;
            }else if(maximumSum<0){
                maximumSum=0;
                starting=true;
            }
        }
        ans[0]=start+1;
        ans[1]=end+1;

        if(maximumSoFar==0)
            return new int[0];

        return ans;

    }
}
