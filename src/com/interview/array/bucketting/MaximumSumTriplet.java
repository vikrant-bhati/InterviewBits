package com.interview.array.bucketting;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class MaximumSumTriplet {
    public static void main(String[] args){
        int[] A = { 21882, 31999, 10323, 18652, 10022, 5700, 3558, 28477, 27893, 24390, 5076, 10713, 2601, 2511, 21004, 26870};
       int ans= solve(A);
        System.out.println(ans);
    }


    public static int solve(int[] A) {
        int ans=Integer.MIN_VALUE;
        Set<Integer> set = new TreeSet<>();
        
        int[] max_right = new int[A.length];
        max_right[0]=A[A.length-1];
        for(int i=1;i<A.length;i++){
            max_right[i]=Math.max(max_right[i-1],A[A.length-1-i]);
        }
        Queue<Integer> queue = new PriorityQueue<>();

        for(int v:max_right)
        System.out.print(v+" ");
        System.out.println("\n"+max_right.length);
        for(int i=1;i<A.length-1;i++){
            int a=A[i];
            if(max_right[max_right.length-2-i]>a) {
                int leftMax = leftMaximum(A, i);
               // System.out.println("left:" + leftMax + " value: " + A[i]);
               // System.out.println(leftMax+" "+i);
                ans = Math.max(ans, (a + leftMax + max_right[max_right.length-2-i]));
                System.out.println(ans+" index: "+i +" a: "+leftMax+" b: "+a+" c: "+max_right[max_right.length-2 - i] +" "+(max_right.length-1 - i));
            }
        }

        return ans;
    }

    public static int leftMaximum(int[] A, int index){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<index;i++){
            if(A[index]>A[i])
            {
                max=Math.max(max,A[i]);
            }
        }
        return max;
    }
}
