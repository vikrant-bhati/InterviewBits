package com.interview.array.Arrangements;

import java.util.ArrayList;

public class FindPermutation {

    public static void main(String[] args){
        String S="DIDD";
        System.out.println(findPerm(S,S.length()));
    }

    public static ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        int min=1;
        for(int i=0;i<A.length();){
            if(A.charAt(i)=='D'){
                while(i<A.length() && A.charAt(i)=='D'){
                    list.add(B);
                    B--;
                    i++;
                }
            }else{
                while(i<A.length() && A.charAt(i)=='I'){
                    list.add(min);
                    min++;
                    i++;
                }
            }
        }
        if(A.charAt(A.length()-1)=='I'){
            list.add(B);
        }else{
            list.add(min);
        }

        return list;
    }
}
