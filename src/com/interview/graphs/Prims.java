package com.interview.graphs;

import java.util.Arrays;
import java.util.Scanner;

public class Prims {
    int[][] matrix;

    public static void main(String[] args) {
        Prims obj = new Prims();
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int v = sc.nextInt();

            int[][] adj = new int[v][3];

            for (int i = 0; i < v; i++) {
                adj[i][0] = sc.nextInt();
                adj[i][1] = sc.nextInt();
                adj[i][2] = sc.nextInt();
            }

            obj.matrix = new int[n + 1][n + 1];
            obj.buildMatrix(adj);
            obj.solution(n);
        } catch (Exception e) {
            obj.testMatrix();
        }

    }

    /**
     * Create adjacent Matrix
     *
     * @param adj
     */
    public void buildMatrix(int[][] adj) {
        for (int[] t : matrix) {
            Arrays.fill(t, Integer.MAX_VALUE);
        }

        for (int[] t : adj) {
            matrix[t[0]][t[1]] = t[2];
            matrix[t[1]][t[0]] = t[2];
        }
    }

    public void testMatrix(){
       int[][] tempMatrix = { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };

        testSolution(5,tempMatrix);
    }

    public void solution(int N) {
        boolean[] isVisited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);
        int[] weight = new int[N + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);

        //Assigning the base condition
        weight[1]=0;
        isVisited[1]=true;
        int next=1;
        // as mst will have n-1 vertices
        for (int i = 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int v=-1;
            //our matrix will be symmetric at i=j
            for(int j=1;j<=N;j++){
                if(matrix[next][j]<min && !isVisited[j]){
                    min=matrix[next][j];
                    v=j;
                }
            }
            isVisited[v]=true;
            parent[v]=next;
            weight[v]=min;
            next=v;

        }

        System.out.println("Parent : "+ Arrays.toString(parent));
        System.out.println("Weight : "+Arrays.toString(weight));

    }


    public void testSolution(int N, int[][] matrix) {
        boolean[] isVisited = new boolean[N ];
        int[] parent = new int[N ];
        Arrays.fill(parent, -1);
        int[] weight = new int[N ];
        Arrays.fill(weight, Integer.MAX_VALUE);

        //Assigning the base condition
        weight[0]=0;
        isVisited[0]=true;
        int next=0;
        // as mst will have n-1 vertices
        for (int i = 0; i < N-1; i++) {
            int min = Integer.MAX_VALUE;
            int v=-1;
            //our matrix will be symmetric at i=j
            for(int j=0;j<N;j++){
                if(matrix[next][j]<min && matrix[next][j]!=0  && !isVisited[j]){
                    min=matrix[next][j];
                    v=j;
                }
            }
            isVisited[v]=true;
            parent[v]=next;
            weight[v]=min;
            next=v;

        }

        System.out.println("Parent : "+ Arrays.toString(parent));
        System.out.println("Weight : "+Arrays.toString(weight));

    }
}
