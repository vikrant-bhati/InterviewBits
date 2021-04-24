package com.interview.graphs;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] matrix = new int[E][2];

        for (int i = 0; i < E; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();

        }
        TopologicalSort obj = new TopologicalSort();
        obj.buildMatrix(matrix);
        Stack<Integer> stack = new Stack<>();
        boolean[]  isVisited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!isVisited[i]){
                obj.dfs(stack,isVisited,i);
            }
        }

        while(!stack.isEmpty()){
            int val=stack.pop();
            System.out.print(val+" ");
        }
        sc.close();

    }

    public void buildMatrix(int[][] matrix) {
        for (int[] temp : matrix) {
            int source = temp[0];
            int destination = temp[1];
            List<Integer> list;
            if (map.containsKey(source)) {
                list = map.get(source);
            } else {
                list = new LinkedList<>();
            }
            list.add(destination);
            map.put(source, list);
        }
    }

    public void dfs(Stack<Integer> stack, boolean[] isVisited, int v) {
        if (isVisited[v]) {
            return;
        }
        isVisited[v] = true;
        if(map.containsKey(v)) {
            for (int val : map.get(v)){
                dfs(stack,isVisited,val);
            }
        }
        stack.push(v);
    }
}
