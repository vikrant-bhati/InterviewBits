package com.interview.graphs;

import java.util.*;

public class KruskalMinimumSpanningTree {
    class Pair{
        int parent;
        int level;

        Pair(int parent, int level){
            this.parent=parent;
            this.level=level;
        }

    }

    List<Pair> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        ArrayList<ArrayList<Integer>> t = new ArrayList<>();
        for(int i=0;i<R;i++){
            ArrayList<Integer> listT = new ArrayList<>();
            for(int j=0;j<C;j++){
                listT.add(sc.nextInt());
            }
            t.add(listT);
        }

        KruskalMinimumSpanningTree obj = new KruskalMinimumSpanningTree();
        System.out.println(obj.solve(N,t));

    }


    //This question on minimum spanning tree and will use kruskal's
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        /* Sort in the ascending order */
        Collections.sort(B, (a, b) -> a.get(2)-b.get(2));

        //     System.out.println(B);
        list.add(null);
        for(int i=1;i<=A;i++){
            list.add(new Pair(-1,0));
        }
        int ans=0;
        for(ArrayList<Integer> temp : B){
            if(!isCyclic(temp.get(0),temp.get(1))){
                ans += temp.get(2);
            }
        }

        printList();

        return ans;
    }

    public boolean isCyclic(int a, int b){
        int first = getParent(a);
        int second = getParent(b);
        if(first==second){
            return true;
        }

        union(first,second);
        return false;

    }
    public int getParent(int a){
        if(list.get(a).parent ==-1){
            return a;
        }

        return list.get(a).parent=getParent(list.get(a).parent);
    }

    public void union(int a, int b){
        if(list.get(a).level > list.get(b).level){
            list.get(b).parent = a;
        }
        else if(list.get(a).level < list.get(b).level){
            list.get(a).parent = b;
        }
        else{
            list.get(a).parent = b;
            list.get(b).level += 1;
        }
    }


    public void printList(){
        int index=1;
        for(;index<list.size();index++){
            Pair n=list.get(index);
            System.out.println("Index is : "+index+" parent is : "+ n.parent+" level is : "+n.level);
        }
    }
}
