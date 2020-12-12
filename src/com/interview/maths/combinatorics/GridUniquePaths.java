package com.interview.maths.combinatorics;


//Good Common question
//https://www.youtube.com/watch?v=Z9XWbqxyn3E --> Good discussion in Dynamic programming
//Try using Loop also
public class GridUniquePaths {
    public static void main(String[] args){
        System.out.println(uniquePaths(2,2));
    }
    public static int uniquePaths(int A, int B) {
        if(A==1 || B==1){
            return 1;
        }
        return uniquePaths(A-1,B)+uniquePaths(A,B-1);
    }

}
