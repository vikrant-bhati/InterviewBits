package com.interview.maths.arrayDP;

import java.sql.SQLOutput;

public class NumbersOfLengthNAndValueLessThanK {

    public static void main(String[] args){
      // int[] A={0,1,2,3,4,5,6};
       //  System.out.println(solve(A,3,461));
        //System.out.println(solve(new int[0],1,1));
        //int[] A={0};
      // int[] A = {0, 1, 2, 5 };
       // int[] A={ 2, 3, 5, 6, 7, 9 };
        //int[] A = {0,1,5};
        int[] A={1, 5, 6, 9};
      //  System.out.println(solve(A,1,123));
        System.out.println(solve(A,2,6346));
    }

    public static int solve(int[] A, int B, int C) {
        String c=Integer.toString(C);
        System.out.println("String is: "+ c+" with length "+c.length());
        if(c.length()<B){
            System.out.println("Inside1");
            return 0;
        }else if(c.length()>B){
           // System.out.println(A[A.length-1]);
            if(B!=1){
                int countZero=0;
                for(int val:A){
                    if(val==0){
                        countZero++;
                    }else{
                        break;
                    }
                }

                return ((int)Math.pow(A.length,B-1)*(A.length-countZero));
            }else{

                return A.length;
            }

        } else{
            int countZero=0;
            boolean notInitial=false;
            for(int val:A){
                if(val==0){
                    countZero++;
                }else {
                    break;
                }
            }
            int ans=1;
            int val;
            int realAns=0;
            for(int i=0;i<c.length();i++){
                val=i+1;
                char temp = c.charAt(i);
                int count=0;

                    while(count<A.length && A[count]<Integer.parseInt(temp+"")){
                        count++;
                    }

                while(val<=B){
                    if(val==1 && B!=1) {
                        ans*=count-countZero;
                        notInitial=true;
                    }else if(notInitial){
                        ans*=A.length;
                    }else{
                        ans*=count;
                        System.out.println("count: "+count);
                        notInitial=true;
                    }
                    val++;
                }
           //     System.out.println("for etrertertertret" + A[count]);
                realAns+=ans;
                notInitial=false;
                ans=1;
                if(count >= A.length || A[count]>Integer.parseInt(temp+"")){
                    break;
                }
            }
            return realAns;
        }
    }
}
