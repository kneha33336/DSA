package org.example.CanPartitionEqualSubsetSum;

public class CanPartitionEqualSubsetSumRecursion {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] nums = new int[]{1, 5, 11, 5};
        int sum = Utils.add(nums);
        boolean canPartition = Utils.canBePartitionedIntoEqualSubsetSum(sum);

        if(!canPartition){
            canPartition = canPartitionEqualSubsetSumRecursion(nums, 0, sum / 2);
        }

        System.out.println("CanPartitionEqualSubsetSumRecursion is: " + canPartition);
    }

    public static boolean canPartitionEqualSubsetSumRecursion(int[] nums, int index, int sum){
        if(sum == 0){
            return true;
        }

        if(index == nums.length){
            return false;
        }

        if(nums[index] <= sum){
            //current index can be included
            boolean include = canPartitionEqualSubsetSumRecursion(nums, index + 1, sum - nums[index]);
            if(include){
                return true;
            }
        }

        boolean exclude = canPartitionEqualSubsetSumRecursion(nums, index + 1, sum);
        return exclude;
    }
}
