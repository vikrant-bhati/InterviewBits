package com.interview.array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MaximumConsecutiveGap {
public static void main(String[] args){
    int[] A ={2095603, 49136908, 31955323, 95163683, 13360539, 25545856, 33526609, 74572519, 57343826, 58884695, 52878838, 69362180, 62707023, 54817858, 51102748, 83388608, 69773694, 33061169, 38346316, 22493129, 94652691, 18563294, 92718371, 33984736, 26975934, 78739392, 11110431, 62686346, 40886895, 75842153, 46436526, 38905503, 46232716, 13324260, 12293992, 59655204, 31204696, 84581975, 11247595, 73034400, 75981557, 50312751, 62109668, 81191851, 28774973, 43395385, 82849932, 85876351, 95874690, 42630641, 99281140, 12777322, 81140371, 75458168, 26854728, 80716953, 44120297, 66125768, 31606604, 85091235, 5636359, 37477728, 92242807, 29739754, 48523811, 60166146, 28672302, 72308957, 25765424, 95251315, 14892806, 5042850, 13073177, 99216860, 19140385, 37674885, 66773703, 12733157, 1761129, 32371950, 58473442, 76379186, 11116812, 76953235, 69223767, 68465113, 51674859, 15945019, 25135831, 64382976, 42370605, 30844804, 49626829, 52307872, 15440986, 68978320, 41715389, 52537016, 78718322, 65383785, 37603361, 57648413, 86621821, 55505364, 58825589, 60859718, 83841336, 60137359, 36452349, 26659575, 95747776, 57070690, 27532572, 40708959, 17337182, 88991700, 56546603, 95853974, 6364384, 84981310, 12631953, 51819859, 55857436, 45556307, 69053455, 65422531, 714938, 17001434, 12341115, 71955864, 9967204, 92616668, 60238507, 85452427, 16945674, 34573997, 94642748, 27636183, 54919788, 6984345, 9845116, 96564143, 13153376, 63915141, 1614302, 70149988, 55592284, 84113937, 26470673, 49426532, 1187886, 75903882, 11241650, 27621854, 85391042, 73340424, 24359631, 49186389, 41902669, 69462017, 86162413, 40963384, 13909129, 62784820, 2960835, 80385424};
    int ans = maximumGap(A);
    System.out.println("\n"+ans);
}

//With sorting
    public static int maximumGapSorting(final int[] A) {
        if (A.length < 2) {
            return 0;
        } else {
            int maxDiff = 0;
            Set<Integer> set = new TreeSet<>();
            for (int val : A) {
                set.add(val);
            }

            Integer[] test = set.toArray(new Integer[A.length]);

            System.out.println("test " + test.length);
            for (int i = 1; i < set.size(); i++) {
                maxDiff = Math.max(maxDiff, (test[i] - test[i - 1]));
            }
            return maxDiff;
        }
    }

    //without sorting
    public static int maximumGap(final int[] A) {
        if (A.length < 2) {
            return 0;
        } else {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int val : A) {
                max = Math.max(max, val);
                min = Math.min(min, val);
            }

            double bucketSize = (double) (max-min) / (double) (A.length - 1);
           // System.out.println("bucketSize: "+bucketSize);
            int[] minVal = new int[A.length-1];
            int[] maxVal = new int[A.length-1];
            Arrays.fill(minVal, Integer.MAX_VALUE);
            Arrays.fill(maxVal, Integer.MIN_VALUE);

            for (int val : A) {
                if((val == max) || (val == min)) {
                    continue;
                }
                int index = (int) Math.floor((val-min) / bucketSize);
               // System.out.println("index: "+index);
                minVal[index] = Math.min(minVal[index], val);
                maxVal[index] = Math.max(maxVal[index], val);
            }
            System.out.println("minimum Array");
            for(int val:minVal)
            System.out.print(val+" ");


            System.out.println("\n maximum Array");
            for(int val:maxVal)
                System.out.print(val+" ");
            int ans=0;
            int prev=min;
            for(int i=0;i<maxVal.length;i++){
                if(maxVal[i]==Integer.MIN_VALUE){
                    continue;
                }
                System.out.println("prev: "+prev+" arr: "+ maxVal[i]+" ans: "+ans+" wqe: "+(maxVal[i]-prev));
                ans=Math.max(ans,(minVal[i]-prev));
              //  System.out.println("ans: "+ans);
                prev=maxVal[i];

            }
            //System.out.println("ans: "+ans);
            ans=Math.max(ans,(max-prev));

            return ans;
        }
    }
}
