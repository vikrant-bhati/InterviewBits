package com.interview.graphs;


import java.util.*;

public class DijkstraForShortestPath {
    class Node{
        int index;
        int weight;

        Node(int index, int weight){
            this.weight=weight;
            this.index=index;
        }
    }
    Map<Integer, List<Node>> adjList = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DijkstraForShortestPath obj = new DijkstraForShortestPath();
       // obj.driverMain(sc);
        obj.driverGFG(sc);
        sc.close();
    }
    public void driverGFG(Scanner sc){
        int N = sc.nextInt();
        buildMatrixGFG(N);
        // System.out.println(adjList);
        System.out.println(solutionGFG(N,2*N));
    }

    public void driverMain(Scanner sc){
        int N = sc.nextInt();
        int V = sc.nextInt();

        int[][] matrix = new int[V][3];
        for(int i=0;i<V;i++){
            matrix[i][0]=sc.nextInt();
            matrix[i][1]=sc.nextInt();
            matrix[i][2]=sc.nextInt();
        }


        buildMatrix(matrix,V);
        System.out.println(solution(N,V));
    }

    public void buildMatrix(int[][] matrix, int N){
        for(int i=0;i<N;i++){
            List<Node> list;
            if(adjList.containsKey(matrix[i][0])){
                list = adjList.get(matrix[i][0]);
            }else{
                list = new LinkedList<>();
            }
            list.add(new Node(matrix[i][1],matrix[i][2]));
            adjList.put(matrix[i][0],list);
        }
    }

    public int solution(int n, int V){
        int[] weight = new int[n];
        boolean[] isVisited = new boolean[n];
        Arrays.fill(weight,Integer.MAX_VALUE);
        weight[0]=0;

        for(int i=1;i<V-1;i++){
            int index = helper(weight,isVisited);
            isVisited[index] = true;
            List<Node> list = adjList.get(index);
            if(list!=null){
                for(Node temp: list) {
                    if (!isVisited[temp.index]){
                        weight[temp.index] = Math.min(weight[temp.index],temp.weight);
                    }
                }
            }
        }

        int ans = 0;
        for(int val:weight){
            ans+=val;
        }

        return ans;
    }

    public int helper(int[] weight, boolean[] isVisited){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<weight.length;i++){
            if(weight[i]<min && !isVisited[i]){
                min=weight[i];
                index=i;
            }
        }
        return index;
    }

    public void buildMatrixGFG(int n){
        for(int i=1;i<=n;i++){
            List<Node> list = new LinkedList<>();
            list.add(new Node(3*i,1));
            list.add(new Node(i+1,1));
            adjList.put(i,list);
        }
    }

    public int solutionGFG(int n, int V){
        int[] weight = new int[n+1];
        boolean[] isVisited = new boolean[n+1];
        Arrays.fill(weight,Integer.MAX_VALUE);
        weight[1]=0;

        for(int i=1;i<V-1;i++){
            int index = helperGFG(weight,isVisited);
            if(index==n){
                break;
            }
            isVisited[index] = true;
            List<Node> list = adjList.get(index);
            if(list!=null){
                for(Node temp: list) {
                    if (temp.index<=n && !isVisited[temp.index]){
                        weight[temp.index] = Math.min(weight[temp.index],temp.weight+weight[index]);
                    }
                }
            }
        }

        return weight[n];
    }

    public int helperGFG(int[] weight, boolean[] isVisited){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<weight.length;i++){
            if(weight[i]<min && !isVisited[i]){
                min=weight[i];
                index=i;
            }
        }
        return index;
    }
}
