package org.example.CanPartitionEqualSubsetSum;

public class CanPartitionEqualSubsetSumTopDown {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] nums = new int[]{1, 5, 11, 5};
        int sum = Utils.add(nums);
        boolean canPartition = Utils.canBePartitionedIntoEqualSubsetSum(sum);

        if(canPartition){
            canPartition = canPartitionEqualSubsetSumTopDownInit(nums,sum / 2);
        }

        System.out.println("CanPartitionEqualSubsetSumTopDown is: " + canPartition);
    }

    public static boolean canPartitionEqualSubsetSumTopDownInit(int[] nums, int sum){
        //create a matrix that can store possible values
        //possible outputs -> true, false, not computed
        //therefore we can't use a boolean matrix
        //we can give these values to possible outputs -> true(1), false(2), not computed(0 -> since it's already default in java)

        int[][] mat = new int[nums.length + 1][sum + 1];
        int output = canPartitionEqualSubsetSumTopDown(nums, 0, sum, mat);
        return mapOutputToBoolean(output);

    }

    public static int canPartitionEqualSubsetSumTopDown(int[] nums, int index, int sum, int[][] mat){
        if(sum == 0){
            return 1;
        }

        if(index == nums.length){
            return 2;
        }

        if(mat[index][sum] != 0){
            return mat[index][sum];
        }

        if(nums[index] <= sum){
            //current index can be included
            int include = canPartitionEqualSubsetSumTopDown(nums, index + 1, sum - nums[index], mat);
            if(mapOutputToBoolean(include)){
                mat[index][sum] = 1;
                return 1;
            }
        }

        int exclude = canPartitionEqualSubsetSumTopDown(nums, index + 1, sum, mat);
        return mat[index][sum] = exclude;
    }

    public static boolean mapOutputToBoolean(int output){
        return output == 1;
    }
}
