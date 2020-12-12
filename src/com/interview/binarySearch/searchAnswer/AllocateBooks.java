package com.interview.binarySearch.searchAnswer;

public class AllocateBooks {
//https://www.youtube.com/watch?v=2JSQIhPcHQg&t=1746s 
    public static void main(String[] args){
        int[] A = {5,17,100,11,19,26,34,42};
        int sum=0;
        for(int val:A){
            sum+=val;
            System.out.print(sum+" ");
        }
        System.out.println("\n"+sum/3);
    }
    public static int books(int[] A, int B) {
        if(A.length <B){
            return -1;
        }

        int start=Integer.MIN_VALUE;
        int end=0;
        for(int val: A){
            start=Math.max(start,val);
            end+=val;
        }
        if(A.length==B){
            return start;
        }

        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isValid(A,B,mid)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return ans;
    }

    public static boolean isValid(int[] A, int B, int mid){
        int count=1;
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(sum>mid){
                count++;
                sum=A[i];
            }
            if(count>B){
                return false;
            }

        }
        return true;
    }
}
