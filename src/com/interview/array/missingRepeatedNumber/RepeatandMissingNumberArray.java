package com.interview.array.missingRepeatedNumber;

import java.util.HashMap;
import java.util.Map;

public class RepeatandMissingNumberArray {


    public int[] repeatedNumber(final int[] A) {
        long sum=0;
        int dub=-1;
        boolean check=true;
        int[] ans = new int[2];
        Map<Integer,Integer> map =new HashMap<>();
        for(int val:A){
            if(check && map.containsKey(val)){
                dub=val;
                check=false;
            }
            sum+=val;
        }
        long val = (long)A.length*((long)A.length+1L)/2L;
        ans[0]=dub;
        ans[1]=(int)(val-(sum-dub));
        return ans;
    }
}
