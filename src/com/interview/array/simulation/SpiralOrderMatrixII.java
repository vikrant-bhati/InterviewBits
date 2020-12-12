package com.interview.array.simulation;

import java.util.Arrays;

public class SpiralOrderMatrixII {

    public static void main(String[] args){
        System.out.println(Arrays.toString(generateMatrix(4)));
    }
    public static int[][] generateMatrix(int A) {
        int [][] arr = new int[A][A];
        int row=0;
        int column=0;
        int count=1;
        int val=A;
        int val1=0;
        String directon="Right";
        while(count<=A*A){
            switch(directon){
                case "Right":
                    while(column<val){
                        arr[row][column]=count;
                        count++;
                        column++;
                    }
                    row++;
                    column--;
                    directon="Down";
                    break;
                case "Down":
                    while(row<val){
                        arr[row][column]=count;
                        count++;
                        row++;
                    }
                    column--;
                    row--;
                    directon="Left";

                    break;
                case "Left":
                    while(column>=val1){
                        arr[row][column]=count;
                        count++;
                        column--;
                    }
                    row--;
                    column++;
                    directon="Top";
                    break;
                case "Top":
                    while(row>val1){
                        arr[row][column]=count;
                        count++;
                        row--;
                    }
                    directon="Right";
                    column++;
                    row++;
                    val--;
                    val1++;
                    break;

            }

        }
        return arr;
    }
}
