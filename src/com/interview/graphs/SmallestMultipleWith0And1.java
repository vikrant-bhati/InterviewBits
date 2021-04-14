package com.interview.graphs;

import java.util.*;

public class SmallestMultipleWith0And1 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        String val;

        TreeNode(String val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SmallestMultipleWith0And1 obj = new SmallestMultipleWith0And1();
        String ans = obj.multiple(n);
        System.out.println(ans);
        sc.close();
    }


    public String multiple(int A) {
        Queue<String> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        String ans = "-1";
        queue.add(1);
        String t = "1";
        list.add(t);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            String tempAns = list.poll();

            if(temp==0){
                ans = tempAns;
                break;
            }else{
                int rem0 = ((temp*10)+1)%A;
                int rem1 = (temp*10)%A;
                if(!map.containsKey(rem0))
                {
                    queue.add(rem0);
                    list.add(tempAns+"1");
                    map.put(rem0,1);
                }
                if(!map.containsKey(rem1))
                {
                    queue.add(rem1);
                    list.add(tempAns+"0");
                    map.put(rem1,1);
                }
            }


        }

        return ans;

    }

    public TreeNode buildSolution(int rem, int A, TreeNode node) {
        if (rem % A == 0) {
            return new TreeNode("0");
        }
        int rem1 = ((rem * 10) + 1) % A;
        int rem0 = (rem * 10) % A;
        node.right = new TreeNode(String.valueOf(rem1));
        buildSolution(rem1, A, node.right);
        node.left = new TreeNode(String.valueOf(rem0));
        buildSolution(rem0, A, node.left);


        /*if(!map.containsKey(rem0)){
            map.put(rem0,1);
            node.left = new TreeNode(String.valueOf(rem0));
            buildSolution(rem0, A, node.left);
        }else{
            node.left=null;
        }
        if(!map.containsKey(rem1)){
            map.put(rem1,1);
            node.right = new TreeNode(String.valueOf(rem1));
            buildSolution(rem1, A, node.right);
        }else{
            node.right=null;
        }*/

        return node;

    }

    public void printNode(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        Queue<TreeNode> queue1 = new LinkedList<>();
        while (!queue.isEmpty() || !queue1.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue1.add(temp.left);
            }

            if (temp.right != null) {
                queue1.add(temp.right);
            }

            if (queue.isEmpty()) {
                queue = queue1;
                queue1 = new LinkedList<>();
                System.out.println();
            }
        }


    }
}
