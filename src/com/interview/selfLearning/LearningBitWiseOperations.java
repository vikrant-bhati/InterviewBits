package com.interview.selfLearning;

public class LearningBitWiseOperations {

    public static void main(String[] args){
        byte b=55;
        System.out.println(b);

        int c = 0B1011;
        System.out.println(c);

        int d=-0B111;
        System.out.println(d);

        int toTest = 0B1111110000;
        System.out.println("Original Value: "+ toTest);
        System.out.println("To remove LSB: "+(toTest & (toTest-1)));
        System.out.println(toTest-1);
        System.out.println("To get the LSB: "+((toTest) & ~(toTest-1)));


        int toTestWithOne = 0B111110011;

        System.out.println("Original Value: "+ toTestWithOne);
        System.out.println("To remove LSB: "+(toTestWithOne & (toTestWithOne-1)));
        System.out.println("To get the LSB: "+((toTestWithOne) & ~(toTestWithOne-1)));


        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

        int higherTricks = 0B1000101000;

        System.out.println(higherTricks);
        System.out.println(higherTricks & (higherTricks + (1 << 9)));

        System.out.println(higherTricks & ~(higherTricks + (1 << 5)));
    }


}
