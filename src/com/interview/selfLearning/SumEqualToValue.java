package com.interview.selfLearning;

import java.util.Arrays;

public class SumEqualToValue {

    public static void main(String[] args){
        int[] A={9,0,1,2,9,8,7,1,4,6};
        int B=1;
        System.out.println(solution(A,B));
    }

    public static int solution(int[] A,int B){
        Arrays.sort(A);
        int pointer1=0;
        int pointer2=A.length-1;
        while(pointer1<pointer2) {
            int sum = A[pointer1] + A[pointer2];
            if ( sum == B) {
                return 1;
            } else {
                if (sum > B) {
                    pointer2--;
                } else {
                    pointer1++;
                }
            }
        }
        return 0;
    }
}
