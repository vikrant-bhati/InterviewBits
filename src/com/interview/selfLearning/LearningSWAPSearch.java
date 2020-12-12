package com.interview.selfLearning;

import java.util.Arrays;

//Note: This algorithm is used when we have repeated number and missing number problem for array
//with length N and number 1-N
//Time complexity is order of N
public class LearningSWAPSearch {
    public static void main(String[] args){
        int[] A = {5,2,3,1,3};
        int[] ans=findTheMissingNumber(A);
        System.out.println("Missing Number is: "+ans[1]+" Repeated Number is: "+ans[0]);
    }

    public static int[] findTheMissingNumber(int[] A){
        int[] ans= new int[2];
        int i=0;
        while(i<A.length){
            if(A[i]!=A[A[i]-1]){
                swap(i,A);
            }else{
                i++;
            }
           System.out.println(Arrays.toString(A));
        }

       i=0;
        for(int val:A){
            if(val!=(i+1)){
                ans[0]=A[i];
                ans[1]=i+1;
                break;
            }else{
                i++;
            }
        }

        return ans;
    }

    public static void swap(int i,int[] A){
        int temp=A[i];
        A[i]=A[A[i]-1];
        A[temp-1]=temp;
        System.out.println(Arrays.toString(A));
    }
}
