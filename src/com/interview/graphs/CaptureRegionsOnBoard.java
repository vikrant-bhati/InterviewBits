package com.interview.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaptureRegionsOnBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        List<String> ll = new ArrayList<>();
        for(int i=0;i<R;i++){
            ll.add(sc.nextLine());
        }
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        for(String s : ll){
            ArrayList<Character> l = new ArrayList<>();
            for(char ch : s.toCharArray()){
                l.add(ch);
            }
            a.add(l);
        }

        CaptureRegionsOnBoard obj = new CaptureRegionsOnBoard();
        obj.solve(a);
        System.out.println(a);
    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        int row = a.size();
        int column = a.get(0).size();

        boolean[][] isVisited = new boolean[row][column];
        boolean[][] done = new boolean[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){

                if(a.get(i).get(j)!='X' && !isVisited[i][j]){
                    traversal(i,j,a,isVisited,done,row-1,column-1);
                }
            }
        }
    }

    public boolean traversal(int r, int c, ArrayList<ArrayList<Character>> a, boolean[][] isVisited, boolean[][] done,int row, int column){

        if(isEdge(r,c,row,column)  ){
            return a.get(r).get(c)=='X';
        }
        if(a.get(r).get(c) == 'X'){
            return true;
        }

        if(isVisited[r][c]){
            if(done[r][c]){
                return a.get(r).get(c)=='X';
            }else{
                return true;
            }
        }

        isVisited[r][c]=true;
        boolean convertLeft = true;
        boolean convertRight = true;
        boolean convertTop = true;
        boolean convertBottom = true;
        if(a.get(r).get(c+1)=='O'){
            convertRight= traversal(r,c+1,a,isVisited,done,row,column);
        }
        if(a.get(r).get(c-1)=='O'){
            convertLeft= traversal(r,c-1,a,isVisited,done,row,column);
        }
        if(a.get(r+1).get(c)=='O'){
            convertTop= traversal(r+1,c,a,isVisited,done,row,column);
        }
        if(a.get(r-1).get(c)=='O'){
            convertBottom= traversal(r-1,c,a,isVisited,done,row,column);
        }
        done[r][c]=true;
        if(convertLeft && convertRight && convertTop && convertBottom){
            a.get(r).set(c,'X');
            return true;
        }else{
            return false;
        }
    }

    public boolean isEdge(int r, int c, int row, int column){
        if(r==0 || c==0 || r== row || c==column){
            return true;
        }
        return false;
    }
}
