package com.interview.maths.combinatorics;

import java.util.*;

public class CityTour {

    public static void main(String[] args){
        Integer[] A={  5, 12, 48, 34, 21, 29, 25, 11, 37, 26, 14, 15, 35, 41, 24, 39, 10, 17, 23, 16, 8, 44, 13, 31};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(A));

       // list.add(1);
        System.out.println( solve(48,list));
    }

    public static int solve(int A, ArrayList<Integer> B) {
        int[] arr = new int[A];
        for(int val:B){
            arr[val-1]=1;
        }
        List<Integer> count = new ArrayList<>();
        int temp=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                temp++;
            }else{
                count.add(temp);
                temp=0;
            }
        }
        count.add(temp);
        System.out.println(Arrays.toString(arr));
        System.out.println("count: "+count);
        long val1=factorial(A-B.size());
        long val2=1L,val3=1L;
        int overflow=0;
        for(int val:count){
            if(val!=0){

                long fact = factorial(val);
              if((val2*fact)>=(long)(1e9 + 7)){
                  overflow++;
                  val2=(val2*fact)% (long)(1e9 + 7);
              }
               else{
                  val2=val2*fact;
              }

            }
        }
        System.out.println("Overflow: "+overflow);
        for(int i=1;i<count.size()-1;i++){
            if(count.get(i)==0){
                continue;
            }
            val3=(val3*(long)Math.pow(2,count.get(i)-1))% (long)(1e9 + 7);
        }
        System.out.println(val1+" val "+ val2+ " val "+val3);
        return (int)((val1/val2)*val3 % (1e9 + 7));
    }

    public static long factorial(int val){
        long fact=1L;

        for(int i=1;i<=val;i++){
            fact=(fact*(long)i)%(long)(1e9 + 7);
        }

        return fact;
    }
}
