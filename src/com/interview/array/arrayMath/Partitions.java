package com.interview.array.arrayMath;

import java.util.Arrays;

public class Partitions {

    public static void main(String[] args){
        int[] A = {1, 2, 3, 0, 3};
        System.out.println(solve(5,A));
    }

    public static int solve(int A, int[] B) {
        int[] prefixArray = new int[A];
        int[] suffixArray = new int[A];
        int prefixSum=0;
        int suffixSum=0;
        for(int i=0;i<A;i++){
            prefixSum+=B[i];
            prefixArray[i]=prefixSum;
            suffixSum+=B[A-1-i];
            suffixArray[i]=suffixSum;
        }
        System.out.println(Arrays.toString(prefixArray));
        System.out.println(Arrays.toString(suffixArray));
        int ans=0;
        if(prefixArray[A-1]%3==0){
            for(int i=0;i<A;i++){
                if(prefixArray[i]==(prefixArray[A-1]/3)){
                    for(int j=A-1-i-2;j>=0;j--){
                        if(suffixArray[j]==(prefixArray[A-1]/3)){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
