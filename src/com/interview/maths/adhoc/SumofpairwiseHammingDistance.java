package com.interview.maths.adhoc;

import java.util.List;

public class SumofpairwiseHammingDistance {

    public int hammingDistance(final List<Integer> A) {

        StringBuilder[] arr = new StringBuilder[A.size()];
        int maxLength=-1;
        for(int i=0;i<A.size();i++){
            arr[i]=bitConversion(A.get(i));
            maxLength=Math.max(maxLength,arr[i].length());
        }

        int[] intArr = new int[maxLength];

        for(StringBuilder val:arr){
            int temp=0;
            for(int i =val.length()-1;i>=0;i--){

                if(val.charAt(i)=='1'){
                    intArr[intArr.length-1-temp]= intArr[intArr.length-1-temp]+1;
                }
                // System.out.print(Arrays.toString(intArr));
                temp++;
            }
        }
        //System.out.print(Arrays.toString(arr));
        //  System.out.print(Arrays.toString(intArr));
        long ans=0L;
        for(int val:intArr){
            ans+=(long)val*(long)(A.size()-val);
        }


        return (int)((2*ans)%1000000007);
    }

    public StringBuilder bitConversion(int A){
        StringBuilder str = new StringBuilder();
        while(A>0){
            str.append(A%2);
            A=A/2;
        }
        return str.reverse();
    }
}
