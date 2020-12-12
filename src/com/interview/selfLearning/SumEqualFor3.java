package com.interview.selfLearning;

import java.util.Arrays;

public class SumEqualFor3 {

    public static void main(String[] args){
        int[] A={9,0,1,2,9,8,7,1,4,6};
        int B=50;
        System.out.println(solution(A,B));
    }

    public static int solution(int[] A, int B){
        Arrays.sort(A);
        for(int i=0;i<A.length-2;i++){
            int val=B-A[i];
            int pointer1=i+1;
            int pointer2=A.length-1;
            while(pointer1<pointer2){
                int sum=A[pointer1]+A[pointer2];
                if(sum==val){
                    return 1;
                }else{
                    if(sum>val){
                        pointer2--;
                    }else{
                        pointer1++;
                    }
                }
            }
        }
        return 0;
    }
}
