package com.interview.selfLearning;

import java.util.Arrays;

public class ValuesLessThanEqualToX {

    public static void main(String[] args){
        int[] A={33,34,35,40,41,45,98,99,110};
        Arrays.sort(A);
        System.out.println(getCount(A,35));
    }

    public static int getCount(int[] A, int val){
        int start=0;
        int end=A.length-1;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(A[mid]>val){
                end=mid-1;
            }else{
                start=mid+1;
                ans=start;
            }
        }

        return (A.length-ans);
    }
}
