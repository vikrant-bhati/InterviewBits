package com.interview.graphs;

import java.util.*;

/**
 * This algorithm is used to find the strongly connected components
 * It uses the concept that taking transpose doesn't change the nature of component nature
 */

//https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1#
public class Kosaraju {

    Map<Integer, List<Integer>> adjList = new HashMap<>();
    int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        int[][] matrix = new int[V][2];
        for (int i = 0; i < V; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }
        sc.close();
        Kosaraju obj = new Kosaraju();
   //     obj.buildList(matrix);
   //     obj.solution(N);
    //    obj.buildTranspose(matrix);
   //     obj.solution(N);
    //    System.out.println("From solution 1 : " + obj.ans);

        obj.correctSolution(N,matrix);

        System.out.println(obj.ans);

    }

    public void solution(int N) {
        boolean[] isVisited = new boolean[N + 1];
        int tempAns = 0;
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                largestSCC(isVisited, i);
                tempAns++;
            }
        }
        ans = Math.max(ans, tempAns);
    }

    public void buildTranspose(int[][] matrix) {
        adjList.clear();
        for (int[] temp : matrix)
            if (adjList.containsKey(temp[1])) {
                List<Integer> list = adjList.get(temp[1]);
                list.add(temp[0]);
                adjList.put(temp[1], list);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(temp[0]);
                adjList.put(temp[1], list);
            }

    }

    public int largestSCC(boolean[] isVisited, int N) {
        isVisited[N] = true;
        int c = 0;
        if (adjList.containsKey(N)) {
            for (int t : adjList.get(N)) {
                if (!isVisited[t]) {
                    c += 1 + largestSCC(isVisited, t);
                }
            }
        }
        return c;
    }

    public void buildList(int[][] matrix) {
        adjList.clear();
        for (int[] temp : matrix)
            if (adjList.containsKey(temp[0])) {
                List<Integer> list = adjList.get(temp[0]);
                list.add(temp[1]);
                adjList.put(temp[0], list);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(temp[1]);
                adjList.put(temp[0], list);
            }
    }

    public void correctSolution(int N,int[][] matrix) {

        buildList(matrix);
        Stack<Integer> stack = fromStart(N);
        // System.out.println(stack);
        buildTranspose(matrix);
        boolean[] isVisited = new boolean[N];
        int tempAns=0;
        while(!stack.isEmpty()){
            int t = stack.pop();
            if(!isVisited[t]){
                dfs(isVisited,t);
                tempAns++;
            }
        }
        ans= Math.max(tempAns,ans);


    }

    public Stack<Integer> fromStart(int N) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[N];
        int tempAns = 0;
        for(int i=0;i<N;i++){
            if(!isVisited[i]){
                dfsUtility(isVisited,i,stack);
                tempAns++;
            }
        }

        ans = Math.max(tempAns,ans);
        return stack;
    }

    public void dfsUtility(boolean[] isVisited, int n, Stack<Integer> stack){
        if(isVisited[n]){
            return;
        }
        isVisited[n]=true;
        if(adjList.containsKey(n)){
            for(int temp:adjList.get(n)){
                if(!isVisited[temp]){
                    dfsUtility(isVisited,temp,stack);
                }
            }
        }
        //    System.out.println("from : "+n);
        stack.push(n);
    }

    public void dfs(boolean[] isVisited, int n){
        if(!adjList.containsKey(n) || isVisited[n]){
            return;
        }
        isVisited[n]=true;
        for(int temp:adjList.get(n)){
            if(!isVisited[temp]){
                dfs(isVisited,temp);
            }
        }

    }

}
