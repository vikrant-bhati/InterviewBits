package com.interview.graphs;

import java.util.*;

public class PossibilityOfFinishingTheCourse {
    class Node{
        boolean isVisited;
        boolean isFinished;

        Node( boolean isVisited,boolean isFinished){
            this.isVisited = isVisited;
            this.isFinished = isFinished;

        }
    }

    List<Node> list = new ArrayList<>();
    Map<Node,List<Node>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> B = new ArrayList<>();
        for(int i=0;i<M;i++){
            B.add(sc.nextInt());
        }
        int O = sc.nextInt();
        ArrayList<Integer> C = new ArrayList<>();
        for(int i=0;i<O;i++){
            C.add(sc.nextInt());
        }

        PossibilityOfFinishingTheCourse obj = new PossibilityOfFinishingTheCourse();
        System.out.println(obj.solve(N,B,C));
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        list.add(null);
        int size = B.size();
        for(int i=1;i<=A;i++){
            list.add(new Node(false,false));
        }

        for(int i=0;i<size;i++){
            if(map.containsKey(list.get(C.get(i)))){
                List<Node> t = map.get(list.get(C.get(i)));
                t.add(list.get(B.get(i)));
            }else{
                List<Node> l = new ArrayList<>();
                l.add(list.get(B.get(i)));
                map.put(list.get(C.get(i)),l);
            }
        }

        for(int i=1;i<=A;i++){
            if(map.containsKey(list.get(i))){
                Node n = list.get(i);
                if(n.isVisited && n.isFinished){
                    continue;
                }else if(n.isVisited && !n.isFinished){
                    return 0;
                }else{
                    if(!possible(map.get(n),0,map.get(n).size())){
                        return 0;
                    }
                }
            }
        }




        return 1;

    }

    public boolean possible(List<Node> list, int index, int size){
        if(index>=size){
            return true;
        }



        if(list.get(index).isVisited && list.get(index).isFinished){
            return true;
        }

        if(list.get(index).isVisited && !list.get(index).isFinished){
            return false;
        }
        list.get(index).isVisited  = true;
        if(map.containsKey(list.get(index))) {
            List<Node> ll = map.get(list.get(index));
            int s = ll.size();
            if (possible(ll, 0, s)) {
                list.get(index).isFinished = true;
                return possible(list, index + 1, size);
            } else {
                return false;
            }
        }else{
            return possible(list, index + 1, size);
        }


    }
}
