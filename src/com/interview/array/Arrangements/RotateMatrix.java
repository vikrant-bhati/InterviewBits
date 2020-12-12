package com.interview.array.Arrangements;

import java.util.ArrayList;

public class RotateMatrix {
    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(31);
        list1.add(32);
        list1.add(228);
        list1.add(333);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(79);
        list2.add(197);
        list2.add(241);
        list2.add(246);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(77);
        list3.add(84);
        list3.add(126);
        list3.add(337);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(110);
        list4.add(291);
        list4.add(356);
        list4.add(371);
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        a.add(list1);
        a.add(list2);
        a.add(list3);
        a.add(list4);
        rotate(a);
    }
    // Geeks for Geeks
    public static void rotate(ArrayList<ArrayList<Integer>> a){
        int len = a.size();
        for(int i=0;i<len/2;i++){
            for(int j=i;j<len-1-i;j++){
            int temp=a.get(i).get(j);
            System.out.println(temp);
            a.get(i).set(j,a.get(len-1-j).get(i));
            System.out.println(a.get(len-1-j).get(i));


            a.get(len-1-j).set(i,a.get(len-1-i).get(len-1-j));
            System.out.println(a.get(len-1-i).get(len-1-j));

            a.get(len-1-i).set(len-1-j,a.get(j).get(len-1-i));


            System.out.println(a.get(j).get(len-1-i));

            a.get(j).set(len-1-i,temp);
            System.out.println(a);

            }
        }
    }

    //from leet code challange
    public static void rotateLeetCode(ArrayList<ArrayList<Integer>> a){
        int len = a.size();
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                int temp=a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
            }
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<len/2;j++){
                int temp=a.get(i).get(j);
                a.get(i).set(i,a.get(i).get(len-1-j));
                a.get(i).set(len-1-j,temp);
            }
        }
    }



    public static void rotateUsingBrain(ArrayList<ArrayList<Integer>> a) {
        int row =a.size();
        Integer[] correct = new Integer[2];
        Integer[] current = new Integer[2];
        Integer[] next = new Integer[2];
        for(int i=0;i<=row/2;i++){
            for(int j=i;j<=row-1-i;j++){
                current[0]=i;
                current[1]=j;

                correct[0]=a.size()-1-j;
                correct[1]=i;

                next[0]=j;
                next[1]=a.size()-1-i;
                int temp;
                while((!correct[0].equals(next[0])) || !(correct[1].equals(next[1]))){

                    temp=a.get(current[0]).get(current[1]);
                    System.out.println(current[0] + " 1 "+ current[1]+" 0 "+next[0]+" 34 "+next[1]);
                    a.get(current[0]).set(current[1],a.get(next[0]).get(next[1]));
                    a.get(next[0]).set(next[1],temp);

                    Integer tempx=next[1];
                    next[1]=a.size()-1-next[0];
                    next[0]=tempx;

                }
                temp=a.get(current[0]).get(current[1]);
                System.out.println(temp);
                a.get(current[0]).set(current[1],a.get(next[0]).get(next[1]));
                a.get(next[0]).set(next[1],temp);
            }
        }
    }
}
