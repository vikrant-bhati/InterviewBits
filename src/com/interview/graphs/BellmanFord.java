package com.interview.graphs;

import java.util.Arrays;
import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1
public class BellmanFord {

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
        BellmanFord obj = new BellmanFord();
        obj.bellmanFord(matrix,V,E);
        sc.close();
    }

    public void bellmanFord(int[][] matrix, int v, int e) {
        int[] weight = new int[v];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        for (int i = 1; i < v; i++) {
            for (int j = 0; j < e; j++) {
                int source = matrix[j][0];
                int destination = matrix[j][1];
                int dist = matrix[j][2];
                if(weight[source]!=Integer.MAX_VALUE) {
                    weight[destination] = Math.min(weight[destination], weight[source] + dist);
                }
            }
        }

        for (int j = 0; j < e; j++) {
            int source = matrix[j][0];
            int destination = matrix[j][1];
            int dist = matrix[j][2];
            if(weight[source]!=Integer.MAX_VALUE && weight[destination]>weight[source] + dist){
                System.out.println("Graph has a negative weighted edge cycle");
                return;
            }
        }

        printMinWeightedGraph(weight);
    }

    public void printMinWeightedGraph(int[] weight){
        System.out.println(Arrays.toString(weight));
    }
}
