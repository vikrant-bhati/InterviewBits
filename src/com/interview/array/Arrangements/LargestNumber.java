package com.interview.array.Arrangements;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
public static void main(String[] args){
    int[] A ={3, 30, 34, 5, 9};
    System.out.println(largestNumber(A));
}
    public static String largestNumber(final int[] A) {
        String[] arr = new String[A.length];
        for(int i=0;i<A.length;i++){
            arr[i]=Integer.toString(A[i]);
        }
        Arrays.sort(arr, new InternalArray());
        StringBuilder ans = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            ans.append(arr[i]);
        }
        if(ans.charAt(0)=='0')
            return "0";
        return ans.toString();
    }
   static class InternalArray implements Comparator<String>{
        public int compare(String s1, String s2){
            if((s1+s2).compareTo(s2+s1)>0){
                return 0;
            }
            return -1;
        }
    }
}
