package com.interview.maths.numberEncoding;

import java.util.ArrayList;

public class RearrangeArray {
    public void arrange(ArrayList<Integer> a) {
        for(int i=0;i<a.size();i++){
            int temp=a.get(a.get(i));
            a.set(i,a.get(i)+((temp%a.size())*a.size()));
        }
        for(int i=0;i<a.size();i++){
            a.set(i,a.get(i)/a.size());
        }
    }
}
