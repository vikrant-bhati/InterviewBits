package com.interview.selfLearning;

public class BinarySearchUsingRecursion{

    public static void main(String[] args){
        int[] A={4, 20, -8};
        System.out.println(binarySearch(A,8,0,A.length-1));
    }

    public static int binarySearch(int[] arr,int A, int start, int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(mid*mid==A){
            return mid;
        }else if(arr[mid]>A){
            binarySearch(arr,A,start,mid-1);
        }else{
            binarySearch(arr,A,mid+1,end);
        }

        return -1;
    }
}
