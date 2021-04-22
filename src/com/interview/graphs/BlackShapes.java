package com.interview.graphs;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BlackShapes {
    Map<String,Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        char[][] matrix = new char[R][C];

        for(int i=0;i<R;i++){
            String s = sc.nextLine();
            int index=0;
            for(char ch : s.toCharArray()){
                matrix[i][index] = ch;
                index++;
            }
           // sc.nextLine();
        }
        BlackShapes obj = new BlackShapes();
        System.out.println(obj.solution(matrix,R,C));
       // System.out.println(obj.map);
        sc.close();
    }

    public int solution(char[][] matrix, int R, int C){
        int ans=0;
        boolean[][] isVisited = new boolean[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!isVisited[i][j] && isValid(R,C,i,j) && matrix[i][j]=='X'){
                    String shape = bfs(matrix, i, j,R,C,isVisited, new StringBuilder("C"));
                    ans++;
                    System.out.println(shape);
                    if(!map.containsKey(shape)){
                        map.put(shape,1);
                    }
                }
            }
        }

       // return map.size();
        return ans;
    }

    public String bfs(char[][] matrix, int x, int y, int R, int C,boolean[][] isVisited,StringBuilder str){
        isVisited[x][y] = true;
        if(isValid(R,C,x,y) && matrix[x][y]=='X') {
            if (isValid(R, C, x, y + 1) && matrix[x][y + 1] == 'X' && !isVisited[x][y + 1]) {
                str.append('R');
                bfs(matrix, x, y + 1, R, C, isVisited, str);
            }
            if (isValid(R, C, x - 1, y) && matrix[x - 1][y] == 'X' && !isVisited[x - 1][y]) {
                str.append('B');
                bfs(matrix, x - 1, y, R, C, isVisited, str);
            }
            if (isValid(R, C, x + 1, y) && matrix[x + 1][y] == 'X' && !isVisited[x + 1][y]) {
                str.append('T');
                bfs(matrix, x + 1, y, R, C, isVisited, str);
            }
            if (isValid(R, C, x, y - 1) && matrix[x][y - 1] == 'X' && !isVisited[x][y - 1]) {
                str.append('L');
                bfs(matrix, x, y - 1, R, C, isVisited, str);
            }
        }


        return str.toString();

    }

    public boolean isValid(int R, int C, int x, int y){
        return x < R && y < C && x >= 0 && y >= 0;
    }

}
