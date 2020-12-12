package com.interview.binarySearch.searchAnswer;

public class SquareRootOfNumber {

    public static void main(String[] args){
        for(int i=0;i<101;i++){
            System.out.println(binarySearch(i));
        }

    }

    public static int binarySearch(int A){
        if(A==0 || A==1){
            return A;
        }

        return binary(A,1,A);
    }

    public static int binary(int A, int start,int end){
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid*mid==A){
                ans= mid;
                break;
            }else if(mid<(A/mid)){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
}
