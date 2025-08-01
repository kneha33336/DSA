package org.example.CanPartitionEqualSubsetSum;

public class CanPartitionEqualSubsetSumBottomUp {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] nums = new int[]{1, 5, 11, 5};
        int sum = Utils.add(nums);
        boolean canPartition = Utils.canBePartitionedIntoEqualSubsetSum(sum);

        if(canPartition){
            canPartition = canPartitionEqualSubsetSumBottomUpInit(nums,sum / 2);
        }

        System.out.println("CanPartitionEqualSubsetSumBottomUp is: " + canPartition);
    }

    public static boolean canPartitionEqualSubsetSumBottomUpInit(int[] nums, int sum){
        //create a matrix that can store possible values
        //possible outputs -> true, false, not computed
        //therefore we can't use a boolean matrix
        //we can give these values to possible outputs -> true(1), false(2), not computed(0 -> since it's already default in java)

        int output = canPartitionEqualSubsetSumBottomUp(nums, sum);
        return mapOutputToBoolean(output);
    }

    public static int canPartitionEqualSubsetSumBottomUp(int[] nums, int sum){
        int[][] mat = new int[nums.length + 1][sum + 1];

        for(int i = 0; i < nums.length + 1; i++){
            mat[i][0] = 1;
        }

        //cautiously starting from j = 1 and not j = 0
        for(int j = 1; j < sum + 1; j++){
            mat[nums.length][j] = 2;
        }

        //Bottom Up approach code
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 1; j < sum + 1; j++){
                if(nums[i] <= j){
                    //can be included
                    int include = mat[i + 1][j - nums[i]];
                    if(include == 1){
                        mat[i][j] = 1;
                        //continue here and don't return, (unlike top down)
                        //since the answer here is mat[0][sum]
                        continue;
                    }
                }
                int exclude = mat[i+ 1][j];
                mat[i][j] = exclude;
            }
        }
        return mat[0][sum];
    }

    public static boolean mapOutputToBoolean(int output){
        return output == 1;
    }
}
