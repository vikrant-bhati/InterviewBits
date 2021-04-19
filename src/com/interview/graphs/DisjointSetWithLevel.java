package com.interview.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisjointSetWithLevel {
class Pair{
    int level;
    int parent;
    Pair(int parent, int level){
        this.level = level;
        this.parent = parent;
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[][] pariList = new int[V][2];
        for(int i=0;i<V;i++){
            pariList[i][0] = sc.nextInt();
            pariList[i][1] = sc.nextInt();
        }
        DisjointSetWithLevel obj = new DisjointSetWithLevel();
        System.out.println(obj.isCyclic(pariList,N));
        sc.close();
    }
    public boolean isCyclic(int[][] arr, int N){
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(new Pair(-1,0));
        }

        for(int[] node:arr){

            int first = find(list,node[0]);
            int second = find(list,node[1]);
            if(first==second){
                return true;
            }else{
                int[] t = {first,second};
                union_operation(t,list);
            }
        }

      //  printList(list);
        return false;

    }

    public int find(List<Pair> arr, int v){
        if(arr.get(v).parent==-1){
            return v;
        }
        return arr.get(v).parent = find(arr,arr.get(v).parent);
    }

    public void union_operation(int[] vertex, List<Pair> arr){
        if(arr.get(vertex[0]).level > arr.get(vertex[1]).level){
            arr.get(vertex[1]).parent = vertex[0];
        }else if(arr.get(vertex[0]).level < arr.get(vertex[1]).level){
            arr.get(vertex[0]).parent = vertex[1];
        }else{
            arr.get(vertex[0]).parent = vertex[1];
            arr.get(vertex[1]).level  += 1;
        }
    }

    public void printList(List<Pair> list){
        int index=0;
        for(Pair p : list){
            System.out.println("Index : "+(++index)+" Parent : "+p.parent+" Level : "+p.level);
        }
    }

}
