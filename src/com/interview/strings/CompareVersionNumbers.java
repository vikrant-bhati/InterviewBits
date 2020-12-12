package com.interview.strings;


import java.util.Arrays;

public class CompareVersionNumbers {

    public static void main(String[] args){
        System.out.println(compareVersion("13.0","13.0.8"));
    }


    public static int compareVersion(String A, String B) {
        System.out.println(B);
        System.out.println(A);
        String[] A1 =A.split("\\.");
        String[] B1 =B.split("\\.");
        System.out.println(Arrays.toString(A1));
        System.out.println(Arrays.toString(B1));
        int minLength=Math.min(A1.length,B1.length);
        for(int i=0;i<minLength;i++){
            StringBuilder str1 = new StringBuilder(A1[i]);
            StringBuilder str2 = new StringBuilder(B1[i]);

            while(str1.length()!=0 && str1.charAt(0)=='0'){
                str1.deleteCharAt(0);
            }
            while(str2.length()!=0 && str2.charAt(0)=='0'){
                str2.deleteCharAt(0);
            }
            for(int j=0;j<Math.min(str2.length(),str1.length());j++){
                if(str1.charAt(j)>str2.charAt(j)){
                    return 1;
                }else if(str1.charAt(j)<str2.charAt(j)){
                    return -1;
                }
            }

            if(str1.length()>str2.length())
                return 1;
            else if(str1.length()<str2.length())
                return -1;

        }
        if(A1.length==B1.length) {
            return 0;
        }
        else if(A1.length>B1.length){
            for(int i=B1.length;i<A1.length;i++){
                if(Integer.valueOf(A1[i])!=0){
                    return 1;
                }
            }
        }else{
            for(int i=A1.length;i<B1.length;i++){
                if(Integer.valueOf(B1[i])!=0){
                    return -1;
                }
            }
        }

        return 0;
    }
}
