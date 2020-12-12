package com.interview.array.arrayMath;

public class MaximumAbsoluteDifference {

    public static void main(String[] args){
        int[] A={19, 65, 42, 66, -44, 45, -42, 17, -52, -59 };
        System.out.println(maxArr(A));
    }

    public static int maxArr(int[] A) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        int max4=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int min3=Integer.MAX_VALUE;
        int min4=Integer.MAX_VALUE;

        for(int i=0;i<A.length;i++){
            max1=Math.max(max1,A[i]+i);
            max2=Math.max(max2,-A[i]+i);
            max3=Math.max(max3,A[i]-i);
            max4=Math.max(max4,-A[i]-i);

            min1=Math.min(min1,A[i]+i);
            min2=Math.min(min2,-A[i]+i);
            min3=Math.min(min3,A[i]-i);
            min4=Math.min(min4,-A[i]-i);

        }
        int ans = Math.max(max1-min1,max2-min2);
        ans = Math.max(max3-min3,ans);
        return Math.max(max4-min4,ans);
    }

}

