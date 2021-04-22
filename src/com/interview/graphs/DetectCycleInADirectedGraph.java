package com.interview.graphs;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
 */
public class DetectCycleInADirectedGraph {
    class Node {
        boolean isVisited;
        boolean isFinished;

        Node(){
            isVisited=false;
            isFinished=false;
        }

        Node(boolean isVisited, boolean isFinished) {
            this.isFinished = isFinished;
            this.isVisited = isVisited;
        }
    }

    Map<Integer, List<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[][] matrix = new int[V][2];
        for (int i = 0; i < V; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }

        DetectCycleInADirectedGraph obj = new DetectCycleInADirectedGraph();
        obj.buildAdjacencyList(matrix);
        System.out.println(obj.isCyclic(N));
        sc.close();
    }

    public void buildAdjacencyList(int[][] matrix) {
        for (int[] temp : matrix) {
            if (adjList.containsKey(temp[0])) {
                List<Integer> list = adjList.get(temp[0]);
                list.add(temp[1]);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(temp[1]);
                adjList.put(temp[0], list);
            }
        }
    }

    public boolean isCyclic(int N) {
        Node[] nodeArr = new Node[N];
        //System.out.println("N value is : "+N);
        for(int j=0;j<N;j++){
            nodeArr[j] = new Node();
        }
        for (int i = 0; i < N; i++) {
            if (cycleDetected(i, nodeArr)) {
                return true;
            }
        }

        return false;
    }

    public boolean cycleDetected(int N, Node[] n) {
        if (n[N].isFinished || !adjList.containsKey(N)) {
            return false;
        } else if (n[N].isVisited) {
            return true;
        }
        n[N].isVisited = true;
        for (int temp : adjList.get(N)) {
            if (cycleDetected(temp, n)) {
                return true;
            }
        }
        n[N].isFinished = true;
        return false;
    }


}
