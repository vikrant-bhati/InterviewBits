package com.interview.twoPointers;


import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args){
        int[] A={9,0,1,9,8,7,4,6};
        int B=3;
        System.out.println(firstMethod(A,B));
    }

    public static int firstMethod(int[] A,int B){
        Arrays.sort(A);
        long ans=0;
        long diff=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            long val=B-A[i];
            long diffInternal=Integer.MAX_VALUE;
            long ansInt=0;
            int pointer1=i+1;
            int pointer2=A.length-1;
            while(pointer1<pointer2) {
                long sum = A[pointer1] + A[pointer2];
                if ( diffInternal > Math.abs(val - sum)) {
                    diffInternal = Math.abs(val - sum);
                    ansInt=sum+A[i];
                }
                if(sum==val){
                    return (int)ansInt;
                }else{
                    if(sum>val){
                        pointer2--;
                    }else{
                        pointer1++;
                    }
                }
            }
            if(diffInternal<diff){
                diff=diffInternal;
                ans=ansInt;
            }

        }
        return (int)ans;
    }
}
