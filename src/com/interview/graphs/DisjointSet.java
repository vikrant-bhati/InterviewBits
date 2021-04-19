package com.interview.graphs;

import java.util.*;

public class DisjointSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[][] A = new int[v][2];
        for(int i=0;i<v;i++){
            int[] B = new int[2];
            B[0] = sc.nextInt();
            B[1] = sc.nextInt();
            A[i] = B;
        }

        DisjointSet obj = new DisjointSet();
        System.out.println(obj.isCycle(A,n,v));
        sc.close();

    }

    public boolean isCycle(int[][] pair, int N, int V){
        int[] arr = new int[N+1];
        Arrays.fill(arr,-1);
        for(int i=0;i<V;i++){
            if(union(arr,pair[i][0],pair[i][1])){
                return true;
            }
        }
        return false;

    }

    public boolean union(int[] arr, int a, int b){
        if(arr[a] == -1 && arr[b]==-1){
            if(a!=b) {
                arr[a] = b;
                return false;
            }else{
                return true;
            }
        }

        if(arr[a]!=-1 && arr[b]!=-1){
           return union(arr,arr[a],arr[b]);
        }else{
            if(arr[a]!=-1){
              return union(arr,arr[a],b);
            }else{
              return union(arr,a,arr[b]);
            }
        }
    }
}
