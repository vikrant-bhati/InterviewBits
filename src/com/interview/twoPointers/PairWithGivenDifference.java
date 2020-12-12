package com.interview.twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairWithGivenDifference {
    // Question is to find the pair with the different as
    // given in question
    public static void main(String[] args){
        /**
         * Test case 1
         int[] A = {5,10,3,2,50,80};
         int B=70;

         *Test Case 2
         int[] A={1,2,3,4,5};
         int B=0;


         * Test Case 3
         int[] A={-10,20};
         int B=30;

         * Test case 4
         int[] A={10,40};
         int B=-30;


         * Test case 5
         int[] A={5,20,3,2,50,80};
         int B=78;
         */


        int[] A={10,40};
        int B=-30;

        System.out.println("Using Hashing: "+solutionHashing(A,B));

        System.out.println("Using Pointer: "+solutionPointer(A,B));

    }
    // Using Hashing
    //Time complexity O(n)
    //Space complexity O(n)
    //Good Solution if we need without sorting
    public static int solutionHashing(int[] arr, int B){
        Map<Integer,Integer> map = new HashMap<>();
        for(int val:arr){
         //   System.out.println((B-val)+" : "+(B+val));
            /**
             * Note here we have to use Val-b
             * val1-val2=B
             * val1=B+val2 --- 1 condition
             * val1-B=val2 --- 2 condition
             */
            if(map.containsKey(val-B)||map.containsKey(B+val)){
                return 1;
            }else{
                map.put(val,val);
            }
        }
        System.out.println(map);
        return 0;
    }

    //Second method of using the pointers but there's pne catch
    // Complexity if array is sorted --> O(n)
    //Complexity if array is not sorted --> O(nlogn)

    public static int solutionPointer(int[] A, int B){
        Arrays.sort(A);
        B=Math.abs(B);
        int pointer1=0;
        int pointer2=1;
        while(pointer1<A.length && pointer2<A.length){
            int diff=A[pointer2]-A[pointer1];
            if(diff==B && pointer1!=pointer2){
                return 1;
            }else{
                if(diff>B){
                    pointer1++;
                }else{
                    pointer2++;
                }
            }
        }
      return 0;

    }
}
