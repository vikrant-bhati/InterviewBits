package com.interview.array.simulation;

import java.util.ArrayList;

public class PascalTriangle {
    public static void main(String[] args){
        System.out.println(solve(5));
    }
    public static ArrayList<ArrayList<Integer>> solve(int A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(A<1){
            return ans;
        }else if(A==1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            ans.add(list);
            return ans;
        }else if(A==2){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(1);
            ans.add(list);
            ans.add(list1);
            return ans;
        }else{

            for(int i=0;i<A;i++){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                for(int j=2;j<=i;j++){
                  list.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j-2));
                }
                if(i!=0){
                 list.add(1);
                }
              ans.add(list);

            }
            return ans;
        }

    }
}
