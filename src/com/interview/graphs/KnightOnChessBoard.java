package com.interview.graphs;

import java.util.*;

public class KnightOnChessBoard {
    class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;

        }

        @Override
        public String toString(){
            return "X : "+ x+" Y : "+y;
        }
    }
    int v=0;
    Map<Node, List<Node>> map = new HashMap<>();
    Map<String, Node> track = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();
        int F = sc.nextInt();

        KnightOnChessBoard obj = new KnightOnChessBoard();
        int ans = obj.knight(A,B,C,D,E,F);

        System.out.println(ans);
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        buildGraph(A,B,C,D);
       // System.out.println(map);
        return solution(A,B,C,D,E,F);
    }

    public int solution(int A, int B, int C, int D, int E,int F){
        boolean[][] isVisited = new boolean[A+1][B+1];
        int[][] weight = new int[A+1][B+1];
        for(int[] temp:weight){
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
        weight[C][D]=0;

        for(int i=1;i<v;i++){
            Node index = helper(weight,isVisited);
            if(null == index){
                break;
            }
            int x = index.x;
            int y = index.y;
            isVisited[x][y]=true;
            String temp = x+" : "+y;
            Node n = track.get(temp);
            List<Node> l = map.get(n);
            if(null==l){
                continue;
            }
            for(Node t: l){
                if(!isVisited[t.x][t.y]){
                    weight[t.x][t.y] = Math.min(weight[t.x][t.y], 1+weight[x][y]);
                }
            }
        }

        return (weight[E][F] == Integer.MAX_VALUE?-1:weight[E][F]);

    }

    public Node helper(int[][] weight, boolean[][] isVisited){
        int max = Integer.MAX_VALUE;
        String index="";
        for(int j=0;j<weight.length;j++){
            for(int i=0;i<weight[0].length;i++){
                if(max>weight[j][i] && !isVisited[j][i]){
                    max = weight[j][i];
                    index = j+" : "+i;
                }
            }
        }

        return track.get(index);

    }


    public void buildGraph(int A, int B, int C, int D){
        int [] x = {2,2,-1,1,-2,-2,1,-1};
        int [] y = {1,-1,2,2,1,-1,-2,-2};
        for(int i =1 ;i<= A; i++){
            for(int j=1;j<=B;j++){
                List<Node> list = new LinkedList<>();
                for(int k = 0;k<8;k++){
                    int X = i+x[k];
                    int Y = j+y[k];
                    if(isValid(X,Y,A,B)){
                        String temp = X+" : "+Y;
                        Node n;
                        if(track.containsKey(temp)){
                            n = track.get(temp);
                        }else{
                            n = new Node(X,Y);
                            track.put(temp,n);
                        }
                        v++;
                        list.add(n);
                    }
                }

                Node n;
                String temp = i+" : "+j;
                if(track.containsKey(temp)){
                    n = track.get(temp);
                }else{
                    n = new Node(i,j);
                    track.put(temp,n);
                }
                map.put(n,list);
            }
        }
    }



    boolean isValid(int x, int y, int A, int B){
        if(x<=0 || y<=0 || x>A || y>B){
            return false;
        }
        return true;
    }
}
