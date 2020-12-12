package com.interview.strings;

public class Stringoholics {

    public static void main(String[] args){
   //    String[] A={"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "babaaaabbaba", "baaaaababaabbaaaaabbbbbbbaabbaaaababbabaababaabaaabbbaaaaa", "abaabb", "aababbbbabbaaaabbaaaaaaaababbbabbbbaabbaabaabbaabaababbbababaababaabbababaaabaaaab", "babaaaaababbbbbabbbbabbaaabaaaababbabbaabbbabbaaaabbbabaaaabaaaababb", "bbbbbbaaaaaabbbbbbababaabaabbbbbaaabbabbaabbbbaaaaaababbabaaabbabbabbbabbaabbabbbbaabbbaaaaabbabaaab", "aabaaabaabbbbababbabbabaaaababbababbbabbbbaabbaaaaababbbbbababbbbaaababababab", "aaaababbbaabbbabaabb", "ababaaaabbabbbbaaabbababbbabbbabaaa", "aaabaabbbabaa", "baababbababbbbbabbabaabbabbbbbaaaabaaaababaa", "babaa", "abbabababbbbbbbbbbbaaaaaababbababaaabbbaaaabbbababbabaabbaabbbbaabbbaabbababababaabaaabbaaabbba", "ababbaabbaaabbbabaabababbbabaaabbbaababaaa", "abbaaaababbbbaaabaaaabaaaaabaababbabbaababbbabbbbbbbbbabbaabaaabbaaababbbaa", "bbabababaabbabbabbbabbaababbabaaabbbababab", "abbbaaabaab", "bbaaabbaaabbaabbabababa", "aabaabaaaaaaabaabbbaaababbbbbbababbaabababbaaaaabbabbbabbbaababbaabababbbbbbbbbaabaab", "babbaaabbabbaabaaabbb", "bbabaabba", "baabaaaaabbaaaaaabbbbaaaabababa", "babbaababaaba", "baabaabaabbababbaabbabbbbbabaaaabbbbbabbabbbbbabbbabaabbbbabbbbaaabbbbabababaaaababbaaabbabb", "abbbbaaaabaabbabbaababaabbababbbaaabbabbbbbaaabbabbaabbb", "bababaaaaabababbabbaabababbbaabbaabaabaabbabbbababbaaabababbababbbb", "abaaabbbabbbaabba", "bbbbaaaabbbababaabbbababaaaababbaaaaaabbbabbaababababbba", "bababaabaaaabbaabbababbaabbaabaabbaaaaaaaababbaaaaaabbaaabaabaaababbababbbbaabbabbabaabab", "aabbbabaaabababaabbbbaabbabaaabbbaaabbabbbbabaabbbbaabbbaaaaabbbabbbbb", "aabbbbbbabaabbbabbaababbababaabaaababbbbabbbaababaaaabbaaabaaabaaaabbbabababbab", "abaaaaababbabaabbbaaaaabbaaaabaaaaaaaababbaabbbaabbabbbabbaaaaaab", "bbbaabbabbbbbbaaaabbabbbbbbbaaabaababbaaaabbbaababbaaabbbbbbbbabbabababbaaabaabaaabaaaabbbbbabaabaaa", "bbaaabaaabaaabaabaaabbaabaabbabaabaabbababaaaaabaabbbbaba", "abaababaaabbabaabaabbbaaabbaabababbabaaabbbbabbbbbaaaaa", "abba", "abbbababbaaabbaaabbbabaabbababaaabbbbaaaaababbabbaabbabbbaaabaabbaaaaabaaaabbbaabbbabbbbbbbabb", "bbabbaaabaaaabbaaaabbbaaaababbbaabaaaaab", "abbaabaabbaaaaaaaabbaabbabbababaaaaaaabbabaabaabbbabbaabbaababbaabbaba", "bbbbaababbaaaaaaaaabbbabbbabaabababaababaababa", "baaabaabbbbbbaabbabbbabaaaaababaabaababbbaaaaaaaabbbbbabbabaaaaaaaabababaabaababaaabbaaaaaaaaabaa", "aababbbabbaaaaababbabaababbbbbbbbaaabbaaaaabbaabbbba", "ababababaaaaaabbbabbaaababaabb", "bababbaababaabbbabbaab", "baababababbaaaaabbbbbbbbbaabababb", "bbbbb", "aabaabbbaabababbababaaaaabbbbaababaabbabbbbbbaabbaaabbababbbabbabbbaabbbab", "bbaabbbbaabbaaaaaabbbaabababbbaabaaabbbbbabaababbbaababbbaaabaaabaaaababbbbaabbaababb", "aaababbaaaaabaabababbabaabbbbabbaba" };
        String[] A={"aaabbbbabbbbabbabbaabbaabbbbaaabbaaaaabbbaaabbabbababbaaaabaaabbaaaaabbbbbbabbbabaaabb", "bbaababbabbbbaabbaabbabbbbbabaaabaabaaabbbabbaaaaabbaaaaaaabaabababbababaaa", "babbbabbbbbbbb", "aababbbababbabbba", "aabababaaaabaabaaabbbbbaabbbaabaaaabbabbababbabbaaabbbbbabbab", "abbbaabbbbbbaabbaaaabbabbaaabbababaabbbabaabbbbbbbbbababaabbbaabbbb", "aabbbbbababababbabbababaabbaaabbbaaaababbbbabb", "babbabaaaaaaaabbbbabbbbabaababbbbabbabaabaaaabbaabbabbaababbbbbbbaa", "babbabbbaabbaabbbbbbaaabbbabbbabbaaabbbababbaaaabbbbabbbbbaaabbabbaaabaabbbbbabbbaababbbbbbbabbbabab", "abbaabbaaaabbbbaaababbaaaabaaaaabaabbaabaaabbbaabba", "aabbaabaabbbbbbabbaababaab", "bbaabbaabababbbaaabbaababbbabbababbbabababbbaabbbbabbbbbaababbb", "aabaabaaabbbaaabbaabbbabbbbbaaabbbbbabbbbaabaaaaaabbbbaa", "abaaabbbbaa", "bbbbbaabaabababaaaaababbaabbbbbaababbaaaababbabbababbbbbbaaabab", "bbaabaabbbaabbbbabababbabb", "abbba", "bbbbbaaaaabbaabbbbaaaaabaabaababaabaababaaaaaabbbbabbaaaabaabaaba", "bbaaaaaaaaaaabbaababbaabbbbbbaaabaabbabbbabbbbbaab", "bbbaabbbabbaaabbbbbaabababaabbbabbababbabaababbbbaabbabbbbaabbaaaababaaabbab", "bbbbbbabababbaabaabaaabaaabbababababaaaabaabaaa", "bbabbbbabbbbabaababbabaababbabbbabaaaaaabbbbbabaaabbbbbababababbbabbabbbbbaabbabbbaabbaabbaabaaaa", "babbbaababaaabbbba", "bbaababbabbaabbbabbbbabbbaaabbaaaaabbbbbaabbaaaabaa", "abbbaabbbaabaaababbaaababaa", "aabaaaaaabbbbbaaabbaaaaabaaaabaabbabaabaababaababbaabbaabbababbbabbaaababbbabbababbbababaaaab", "aaabaabbabaababbbbaaaabababbaaaaabbbbbaaababbbaaabaabbbbbaaaababaaabbabb", "baaaaaababbaaabaabababbabbbaaabaaaaaabababbabaabaabaaaabbbbabbabbabbbbababbbabbaaaaa", "ababbaaaabbaaaaabbaabaaabaabaabaabbbbbbbaaabaabbbbaabab", "bbbbabaaabbabab", "abaabbabbabaaabbaababbaaababbb", "bbbbabbbabbaabbbbaabbbbbaabb", "baaaaaabbabb", "bbabaabbbaabaabbabaaba"};
        System.out.println(solve(A));

    }

    public static int solve(String[] A) {
        long ans=1L;
        for(int i=0;i<A.length;i++){
            StringBuilder str = new StringBuilder(A[i]);
            long count=1L;
            /*for(int j=0;j<str.length();j++)
            {
                char temp = str.charAt(0);
                str.deleteCharAt(0);
                str.append(temp);
                System.out.println("str: "+str);
                if(A[i].equals(str.toString())){
                    break;
                }
                count++;
            }*/
            while(true){
                 str = rotateString(str,count);
                 if(A[i].equals(str.toString())){
                     break;
                 }else{
                     count++;
                 }

            }
         //  System.out.println("count: "+count);
            if(i==1){
                ans=(((LCM(count,count)))%1000000007);
            }else{
                ans=((LCM(ans,count))%1000000007);
            }
            System.out.println(ans);
        }

        return (int)(ans%1000000007);
    }

    public static StringBuilder rotateString(StringBuilder str, long val){
        val=val%str.length();
        StringBuilder ans = new StringBuilder(str.substring((int)val));
        ans.append(str.substring(0,(int)val));
        return ans;
    }

    public static long LCM(long A, long B){

     //   return ((((A%1000000007)*(long)(Math.pow(GCD(A,B),1000000007-2)%1000000007)%1000000007)*B)%1000000007);
      // return Math.floorMod((((A/GCD(A,B) )* B)),1000000007);
        return (((A/GCD(A,B) )* B));
    }

    public static long GCD(long A, long B){
        if(A==0){
           // System.out.println(B);
            return B;
        }
        return  GCD(B%A,A);

    }
}
