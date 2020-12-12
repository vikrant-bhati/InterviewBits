package com.interview.array.Arrangements;


import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] A = {769, 533};
        System.out.println(Arrays.toString(nextPermutation(A)));
    }

    public static int[] nextPermutation(int[] A) {
        if (A.length > 1) {
            int index=-1;
           for(int i=A.length-2;i>0;i--){
               if(A[i]<A[i+1]){
                   index=i;
                   break;
               }
           }
           int start=0;
           int end=A.length-1;
           int temp;
           if(index==-1){
               while(start>end){
                   temp=A[start];
                   A[start]=A[end];
                   A[end]=temp;
                   start++;
                   end--;
               }
               return A;
           }
           int diff = Integer.MAX_VALUE;
           int diffIndex=-1;
        for(int i=index+1;i<A.length;i++){
            if(A[index]<A[i] && A[i]-A[index]<diff){
                diff=A[i]-A[index];
                diffIndex=i;
            }
        }

        temp=A[index];
        A[index]=A[diffIndex];
        A[diffIndex]=temp;

        start=index+1;
        end=A.length;
        while(start>end){
            temp=A[start];
            A[start]=A[end];
            A[end]=temp;
        }

        }
        return A;
    }
}
