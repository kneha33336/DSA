package org.example.CanPartitionEqualSubsetSum;

public class Utils {
    public static int add(int[] nums) {
        int numsSummation = 0;
        for(int index = 0; index < nums.length; index++){
            numsSummation += nums[index];
        }

        return numsSummation;
    }

    public static boolean canBePartitionedIntoEqualSubsetSum(int sum){
        //if summation of nums is odd, then surely it can't be divided into exactly two equal subsets
        return sum % 2 == 0;
    }
}
