package com.interview.strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddresses {

//Failing for A : "0100100"
    // Expected ans -->0.10.0.100 0.100.10.0
    public static void main(String[] args){
        String A="0100100";
        System.out.println(restoreIpAddresses(A));
    }

    public static List<String> restoreIpAddresses(String A) {
        List<String> ans = new ArrayList<>();
        if(A.length()<4 || A.length()>12){
            return  ans;
        }


        int pointer1 =1;
        int pointer2 =2;
        int pointer3 =3;
        boolean isString1Valid=true;
/*        boolean isString2Valid=true;
        boolean isString3Valid=true;
        boolean isString4Valid=true;*/

        while(isString1Valid && pointer3<A.length()){
            StringBuilder str1 = new StringBuilder(A.substring(0,pointer1));
            StringBuilder str2 = new StringBuilder(A.substring(pointer1,pointer2));
            StringBuilder str3 = new StringBuilder(A.substring(pointer2,pointer3));
            StringBuilder str4 = new StringBuilder(A.substring(pointer3));

            while(pointer3<A.length() && !isValid(str4)){
                str3.append(A.charAt(pointer3));
                str4.deleteCharAt(0);
                pointer3++;
            }

            while(pointer2<A.length() && !isValid(str3)){
                str2.append(A.charAt(pointer2));
                str3.deleteCharAt(0);
                pointer2++;
            }

            while(pointer1<A.length() && !isValid(str2)){
                str1.append(A.charAt(pointer2));
                str2.deleteCharAt(0);
                pointer1++;
            }

            if(isValid(str1)){
                str1.append('.');
                str1.append(str2);
                str1.append('.');
                str1.append(str3);
                str1.append('.');
                str1.append(str4);
                ans.add(str1.toString());
                pointer3++;
            }
            else {
                isString1Valid=false;
            }
        }
        return ans;

    }


    public static boolean isValid(StringBuilder str){
        if(str.length()==0){
            return false;
        }else if(str.charAt(0)=='0'){
            if(Integer.valueOf(str.toString())==0){
                return true;
            }else {
                return false;
            }
        }else{
           if(Integer.valueOf(str.toString())>=0 && Integer.valueOf(str.toString())<=255){
               return true;
           }else{
               return false;
           }
        }
    }
}
