package com.interview.array;

public class MaximumContiguousSubArray {

    public static void main(String[] args) {
        System.out.println("Hello World !");

        int[] A ={3,-2,5,-1 };
   //     maximumSum(A);
      //  System.out.println(maximim(A));
        maximimSecondApproach(A);
    }

    public static void maximumSum(int[] A){
        int max=Integer.MIN_VALUE;
        int maxCont =Integer.MIN_VALUE;
        for (int j : A) {
            if ((max + j) > max && max>j) {
                max = max + j;
            } else {
                max = j;
            }
            System.out.println("Max"+max);
            if (maxCont < max) {
                maxCont = max;
            }
        }
        System.out.println(maxCont);
    }
//Brute Force Method
    public static int maximim(int[] A){
        int ans = Integer.MIN_VALUE;
    for(int subArraySize=1; subArraySize<=A.length; subArraySize++){
        // Sub array of size 1
        for(int startIndex=0;startIndex<A.length;startIndex++){
            // started with array index 0
            // startIndex = 1
            if(startIndex+subArraySize>A.length){
                break;
            }
            int sum=0;
            for(int i=startIndex;i<(subArraySize+startIndex);i++){
                //0+1 = 1
                // 1+1
                sum+=A[i];
                System.out.println("sum"+sum);
                ans=Math.max(sum,ans);
            }
        }
    }
        System.out.println(ans);
    return ans;
    }

    //second approach complexity n2
    public static int maximimSecondApproach(int[] A){

        int ans =Integer.MIN_VALUE;
        for(int j=0;j<A.length;j++){
            int sum=0;
            for (int startIndex=j;startIndex<A.length;startIndex++){
                    sum+=A[startIndex];
                System.out.print(sum+" ");
                ans=Math.max(sum,ans);
            }
            System.out.println();

        }
        System.out.println("ans: "+ans);

        return ans;
    }

}
