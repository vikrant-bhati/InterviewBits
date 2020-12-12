package com.interview.array.valueRange;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {
    public static void main(String[] args){

    }
//Must solve once again using comparator to compare directly
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() > 1) {
            int[] startArray = new int[intervals.size()];
            int[] endArray = new int[intervals.size()];
            ArrayList<Interval> ans = new ArrayList<>();
            int count = 0;
            for (Interval val : intervals) {
                startArray[count] = val.start;
                endArray[count] = val.end;
                count++;
            }
            Arrays.sort(startArray);
            Arrays.sort(endArray);


            for (int i = 0; i < intervals.size()-1; i++) {
                int start = startArray[i];
                int end = endArray[i];

                while (i<intervals.size()-1 && startArray[i+1]<=end){
                    end=endArray[i+1];
                    i++;
                }

                Interval interval = new Interval(start,end);
                ans.add(interval);

            }

            return ans;
        }
    return intervals;
    }


}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
