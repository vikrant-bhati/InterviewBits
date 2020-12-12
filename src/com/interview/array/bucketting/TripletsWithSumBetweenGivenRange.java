package com.interview.array.bucketting;

public class TripletsWithSumBetweenGivenRange {

    public static void main(String[] args){
        String[] A={"0.628934", "0.939859", "0.898308"};
        System.out.println(solve(A));
    }
//Logic is explained :
//https://stackoverflow.com/questions/19557505/triplet-whose-sum-in-range-1-2
    //Important thing to learn --> Float and Double stores minimum possible positive value in MIN_VALUE
    public static int solve(String[] A) {

        float range1 = (float)2/3;// As when number will be (max range/3)
        float range2 = (float)2/2;// As this is the half of (max range/2)
        float max1a=Float.MIN_VALUE,max2a=Float.MIN_VALUE,max3a=Float.MIN_VALUE;
        float max1b=Float.MIN_VALUE;
        float min1a=Float.MAX_VALUE,min2a=Float.MAX_VALUE,min3a=Float.MAX_VALUE;
        float min1b=Float.MAX_VALUE,min2b=Float.MAX_VALUE,min1c=Float.MAX_VALUE;

        for(String s:A) {
            float val = Float.parseFloat(s);
            if(val<range1){
               System.out.println(val+" "+range1);
            if (val > max1a) {
                max3a = max2a;
                max2a = max1a;
                max1a = val;
                System.out.println("from1: "+max1a+" "+max2a+" "+max3a);
            } else if (val > max2a) {
                max3a = max2a;
                max2a = val;
                System.out.println("from2: "+max1a+" "+max2a+" "+max3a);
            } else if (val > max3a) {
                max3a = val;
                System.out.println("from3: "+max1a+" "+max2a+" "+max3a);
            }
            if (val < min1a) {
                min3a = min2a;
                min2a = min1a;
                min1a = val;
            } else if (val < min2a) {
                min3a = min2a;
                min2a = val;
            } else if (val < min3a) {
                min3a = val;
            }
        }else if(val<=range2){
                if(val<min1b){
                    min2b=min1b;
                    min1b=val;
                }else if(val<min2b){
                   min2b=val;
               }
               max1b=Math.max(val,max1b);
            }else{
                min1c=Math.min(min1c,val);
            }
        }
       if((max1a+max2a+max3a)>1.0){
           System.out.println(max1a+" "+max2a+" "+max3a);
           return 1;
       }else if((max1a+max2a+min1b<2)&&(1<max1a+max2a+min1b) && (max2a!=Float.MIN_VALUE)){
           System.out.println(max1a+" "+max2a+" "+min1b);
           return 2;
       }else if(min1a+min1b+min2b<2){
           return 3;
       }else if(min1a+min1b+min1c<2){
           return 4;
       }else if(min1a+min2a+min1c<2){
           return 5;
       }else if((min1a+min2a+max1b<2)&&(min1a+min2a+max1b>1)&& (max1b!=Float.MIN_VALUE)){
           return 6;
       }

    return 0;
    }
}
