package org.example.SubsetSum;

public class SubsetSumRecursion {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] nums = new int[]{3, 34, 4, 12, 5, 2};
        int sum = 9;
        int ans = subsetSumRecursion(nums, 0, sum);
        System.out.printf("TargetSumRecursion ans: " + ans);
    }

    public static int subsetSumRecursion(int[] nums, int index, int sum){
        if(sum == 0){
            return 1;
        }
        if(index == nums.length){
            return 0;
        }
        if(nums[index] <= sum){
            //include
            int include = subsetSumRecursion(nums, index + 1, sum - nums[index]);
            if(include == 1){
                return 1;
            }
        }
        int exclude = subsetSumRecursion(nums, index + 1, sum);
        return exclude;
    }
}
