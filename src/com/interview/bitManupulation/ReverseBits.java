package com.interview.bitManupulation;

public class ReverseBits {
    public static void main(String[] args){
    long toRev=32;
    long rev=0;
    for(int i=0;i<32;i++){
        rev<<=1;
        if((toRev&(1<<i))!=0){
            rev |= 1;
        }
    }
        System.out.println(rev);
    }





 /**   public static void main(String[] args){
        StringBuilder str = new StringBuilder();
        long a=0;
        while(a>0){
            str.append(a%2);
            a=a/2;
        }
        while(str.length()!=32){
            str.append('0');
        }
        System.out.println(str);
        System.out.println(intValue(str));
    }

    public static long intValue(StringBuilder str){
        long val=0;

        for(int i=str.length()-1;i>=0;i--){
            System.out.println(Long.valueOf(str.charAt(i)+""));
            val+=(Long.valueOf(str.charAt(i))*Math.pow(2,str.length()-1-i));
            System.out.println(val);
        }
        return val;
    }**/
}
