package com.interview.maths.examples;

import java.util.ArrayList;

public class AllFactors {
    public static void main(String[] args){
        System.out.println(allFactors(85463));
    }
   // https://www.youtube.com/watch?v=dolcMgiJ7I0&feature=emb_err_woyt
    //Concept to find the factors
    public static ArrayList<Integer> allFactors(int A) {

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        //Find the sqrt of A
        int val = (int)Math.sqrt(A);
        for(int i=1;i<=val;i++){
            if(A%i==0){
                ans.add(i);
                if(A/i!=i) {
                    ans2.add(A/i);
                }
            }
        }

        for(int i=ans2.size()-1;i>=0;i--){
            ans.add(ans2.get(i));
        }

        return ans;
    }
}
