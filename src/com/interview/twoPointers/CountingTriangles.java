package com.interview.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingTriangles {
 public static void main(String[] args){
     int[] A={4, 6, 13, 16, 20, 3, 1, 12 };
     System.out.println(solution(A));

 }
 public static long solution(int[] A){
     if(A.length<3){
         return 0;
     }else{
         Arrays.sort(A);
         List<List<Integer>> list = new ArrayList<>();
         long ans=0L;
         for(int i=0;i<A.length-2;i++){
             if(((i==0)|| !(A[i]==A[i-1] && A[i]==A[i+1]))&&(A[i]!=0)){
                 int pointer1=i+1;
                 int pointer2=A.length-1;
                 while(pointer1<pointer2) {

                     if (A[i] + A[pointer1] > A[pointer2]) {
                         if (A[i] == A[pointer1] && A[i] == A[pointer2]) {
                             ans += 1;
                         } else if (A[i] == A[pointer1] || A[pointer1] == A[pointer2]) {
                             ans += 3;
                         } else {
                             ans += 6;
                         }
                         list.add(Arrays.asList(A[i],A[pointer1],A[pointer2]));
                         while(pointer1<pointer2 && A[pointer1]==A[pointer1+1]){
                             pointer1++;
                         }
                         while(pointer2>pointer1 && A[pointer2]==A[pointer2-1]){
                             pointer2--;
                         }
                     }
                     pointer2--;

                 }
             }
         }
         System.out.println(list);
         return ans;
     }
 }


}
