package com.interview.maths.numberTheory;

//Note the question can have repeated lower and upper case characters
public class SortedPermutationRankWithoutRepeats {

    public static void main(String[] args){
        System.out.println(findRank("RANDOM"));

    }

    //make sense
    public static int findRankOld(String A) {
        long ans=1L;
        for(int i=0;i<A.length();i++){
            int count=0;
            for(int j=i+1;j<A.length();j++){
                if(A.charAt(i)>A.charAt(j)){
                    System.out.println(A.charAt(i)+ " compare "+A.charAt(j));
                    count++;
                }
            }
            ans=ans+(count*fact(A.length()-1-i));
            System.out.println("ans: "+ans+" count: "+count);
        }
        return (int)(ans%1000003L);

    }

    public static long factOld(int val){
        long ans=1L;
        for(int i=2;i<=val;i++){
            ans*=i;
        }
        return ans;
    }



    // Better Solution

    public static int findRank(String A) {
        long ans=1L;
        long[] facts = new long[A.length()];
        for(int i=0;i<A.length();i++){
            if(i==0){
                facts[i]=1L;
            }else{
                facts[i]=(facts[i-1]*i)%1000003L;
            }

        }

        for(int i=0;i<A.length();i++){
            int count=0;
            for(int j=i+1;j<A.length();j++){
                if(A.charAt(i)>A.charAt(j)){
                    // System.out.println(A.charAt(i)+ " compare "+A.charAt(j));
                    count++;
                }
            }
            ans=(ans+(count*(facts[facts.length-1-i])%1000003L)%1000003L);
            //  System.out.println("ans: "+ans+" count: "+count);
        }
        // System.out.println(Arrays.toString(facts));
        return (int)(ans%1000003L);

    }

    public static long fact(int val){
        long ans=1L;
        for(int i=2;i<=val;i++){
            ans*=i;
        }
        return ans;
    }

}
