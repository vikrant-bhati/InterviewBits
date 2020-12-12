package com.interview.maths.adhoc;

import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoIntegers {
    public static void main(String[] args){
        for(int i=1;i<50;i++) {
            System.out.println(isPower(i)+ " number is "+i);
        }
    }

    public static int isPower(int A) {

        if(A==1){
            return 1;
        }
        List<Integer> facts = new ArrayList<>();

        for(int i=2;i<=(int)Math.sqrt(A);i++){
            if(A%i==0){
                facts.add(i);
            }
        }

        if (!facts.isEmpty()) {
            for (int val : facts) {
                int temp = A;
                while (temp > 1) {
                    if (temp % val != 0) {
                        break;
                    }
                    temp = temp / val;
                }
                if (temp == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
