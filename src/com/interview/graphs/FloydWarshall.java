package com.interview.graphs;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] matrix = new int[E][3];
        for (int i = 0; i < E; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
            matrix[i][2] = sc.nextInt();
        }
        FloydWarshall obj = new FloydWarshall();
        int[][] list = obj.buildList(matrix, V);
        for (int i = 0; i < V; i++) {
            obj.updateList(list, i, V);
        }
        for (int[] temp : list) {
            System.out.println(Arrays.toString(temp));
        }
    }

    int[][] buildList(int[][] matrix, int V) {
        int[][] list = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    list[i][j] = 0;
                } else {
                    list[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int[] temp : matrix) {
            list[temp[0]][temp[1]] = temp[2];
        }

        return list;
    }

    void updateList(int[][] list, int k, int V) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                int weightCurrent = list[i][j];
                int weightFromOne = list[i][k];
                int weightFromSecond = list[k][j];
                if (weightFromOne == Integer.MAX_VALUE || weightFromSecond == Integer.MAX_VALUE) {
                    continue;
                }
                weightCurrent = Math.min(weightCurrent, weightFromOne + weightFromSecond);
                list[i][j] = weightCurrent;
            }
        }
    }


}
