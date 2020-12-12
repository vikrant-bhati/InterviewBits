package com.interview.array.simulation;

import java.util.ArrayList;
//the formula to calculate it is --> https://www.geeksforgeeks.org/find-the-nth-row-in-pascals-triangle/
public class KthRowofPascalTriangle {

    public static void main(String[] args){
        System.out.println(getRow(1));
    }

    public static ArrayList<Integer> getRow(int A) {
        if(A<1){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
            return ans;
        }
        int val =1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(val);
        for(int i=1;i<A;i++){
            int temp = val*(A-i+1)/i;
            ans.add(temp);
            val=temp;
        }
        ans.add(1);
        return ans;
    }
}
