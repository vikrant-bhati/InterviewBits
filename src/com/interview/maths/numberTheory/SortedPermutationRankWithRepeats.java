package com.interview.maths.numberTheory;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortedPermutationRankWithRepeats {
    public static final int mod = 1000003;
    public static void main(String[] args){
        System.out.println(findRank("asasdsdsadasdadsadasdsa"));
    }
    //mm
    //sadasdsasassasas
    //asasdsdsadasdadsadasdsa
    public static int findRank(String A) {
        long[] fact = new long[A.length()+1];
        long[] infact = new long[A.length()+1];
        fact[0]=infact[0]=1;

        for(int i=1;i<=A.length();i++){
                fact[i]=(fact[i-1]*i)%mod;
                infact[i]=modExp(fact[i],mod-2);
        }

        System.out.println(Arrays.toString(infact));

        long ans =1L;
        for(int i=0;i<A.length();i++){
            long count =0L;
            long d=1L;
            Map<Character,Integer> map = new HashMap<>();
            for(int j=i;j<A.length();j++){
                if(A.charAt(i)>A.charAt(j)){
                    count++;

                }
                if(map.containsKey(A.charAt(j))){
                    map.put(A.charAt(j),map.get(A.charAt(j))+1);
                }else{
                    map.put(A.charAt(j),1);
                }
            }
            for(int val:map.values()){
                System.out.print("val: "+val+ " for: "+ i);
                d=(d*infact[val])%mod;
            }
            System.out.println(" D is: "+d);

          //  d=(long)(Math.pow(d,1000003-2)%1000003);
            //ans=(ans+(count*((fact[A.length()-1-i]))*(long)Math.pow(d,1000003-2)%1000003)%1000003)%1000003;
            ans = (ans+count*fact[A.length()-1-i]*d)%mod;
        }

     //  System.out.println("ans "+ans);
        return (int)ans%1000003;

    }



  //Note this for understanding purpose only
 // When we are having very big integers we should use BigInteger
//This is with BigInteger Class
    public class Solution {
        public int findRank(String A) {
            int n = A.length();
            char[] chars = A.toCharArray();
            byte[] ascii = new byte[256];

            BigInteger[] factors = new BigInteger[n + 1];
            factors[0] = BigInteger.ONE;
            for (int i = 1; i <= n; i++) {
                factors[i] = factors[i - 1].multiply(new BigInteger(String.valueOf(i)));
                // System.out.printf("%s!  = %s\n", i, factors[i].toString());
            }
            factors[0] = BigInteger.ZERO;

            BigInteger rank = BigInteger.ONE;
            BigInteger denominator, numerator;
            BigInteger MOD = new BigInteger(String.valueOf(1000003));
            for (int i = 0; i < n; i++) {
                long count = 0;
                Arrays.fill(ascii, (byte)0); // clear
                ascii[ chars[i] ]++;
                for (int j = i + 1; j < n; j++) {
                    if (chars[j] < chars[i]) {
                        count++;
                    }
                    ascii[ chars[j] ]++;
                }
                numerator = factors[n - i - 1].multiply(new BigInteger(String.valueOf(count)));
                // numerator %= 1000003;

                denominator = BigInteger.ONE;
                for (int j = 0; j < 256; j++) {
                    if (ascii[j] > 0) {
                        // System.out.printf("  %c = %s -> %s!\n", (char)j, ascii[j], factors[ ascii[j] ]);
                        // denominator *= factors[ ascii[j] ];
                        // denominator %= 1000003;
                        denominator = denominator.multiply(factors[ ascii[j] ]);
                    }
                }
                // denominator = Math.max(denominator, 1);
                // System.out.printf("(%s * %s) / %s\n", count, factors[ n - i - 1], denominator);

                //rank += (numerator / denominator) ;
                rank = rank.add(numerator.divide(denominator));
                rank = rank.mod(MOD);
                // rank %= 1000003;
            }
            return Integer.parseInt(rank.toString());
        }
    }



    public static long modExp(long xint, long yint) {
        long res = 1;
        long x = xint;
        long y = yint;
      //  System.out.println("Exp1 " + x + " " + y + " " + res);
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            y >>= 1;
         //   System.out.println("Exp2 " + x + " " + y + " " + res);
        }
        //return new Long(res).intValue();
        return res;
    }
}
