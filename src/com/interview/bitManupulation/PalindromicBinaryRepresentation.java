package com.interview.bitManupulation;

public class PalindromicBinaryRepresentation {

    public static void main(String[] args){
      //  for(int i=1;i<15;i++)

  //      System.out.println("Ceil is: "+(Math.ceil((double)3/2)));

        System.out.println(solve(14));

       // System.out.println("ans of reverse is: "+reverse(3));
    }

    public static int solve(int A) {
        if(A==1){
            return 1;
        }else if(A==2){
            return 3;
        }else {
            int length = 2;
            int count = 2;
            while (count < A) {
                length++;
                count += Math.pow(2, Math.ceil((double)(length - 2) / 2));
                System.out.println(length + " value: " + count);
            }
            count-=Math.pow(2, Math.ceil((double)(length - 2) / 2));
            --length;

           System.out.println(length+" test "+(A-count-1));

            int ans=1<<length;

            ans=  ans|((A-count-1)<<(int)(Math.ceil((double)length/2)));

           // System.out.println(ans+ "test");

            ans|=reverse(ans);
         //   System.out.println(count+ " "+ length+" "+ans);
            return ans;
        }

    }


    public static int reverse(int val){
        int ans=0;
        while(val!=0){
            ans= ans<<1;
            ans=ans|(val&1);
       //     System.out.println(ans);
            val=val>>1;
        }

        return ans;
    }
}
