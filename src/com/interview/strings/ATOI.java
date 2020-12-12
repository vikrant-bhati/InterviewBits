package com.interview.strings;

public class ATOI {

    public static void main(String[] args){
        System.out.println(atoi( "5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393"));
        System.out.println("test "+((int)'7'-(int)'0'));
    }

    public static int atoi(final String A) {
        StringBuilder str = new StringBuilder(A.trim());
        boolean isNegative=false;
        if(str.charAt(0)=='-' || str.charAt(0)=='+'){
            if(str.charAt(0)=='-')
            isNegative=true;
            str.deleteCharAt(0);
        }
        System.out.println(str);
        long ans=0;
        int index=0;
        while(ans<=Integer.MAX_VALUE && index<str.length()){
            char c=str.charAt(index);
            if(c>='0' && c<='9'){
                ans=(ans*10)+((int)c-(int)'0');
            }else{
                break;
            }
            index++;
        }

        if(ans>=Integer.MAX_VALUE ) {
            if (isNegative)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }

            ans= isNegative?-ans:ans;
            return (int)ans;


    }
}

