package org.example.SubsetSum;

public class SubsetSumTopDown {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] nums = new int[]{3, 34, 4, 12, 5, 2};
        int sum = 9;
        int ans = subsetSumTopDownInit(nums, 0, sum);
        System.out.printf("SubsetSumTopDown ans: " + ans);
    }

    public static int subsetSumTopDownInit(int[] nums, int index, int sum){
        int[][] mat = new int[nums.length + 1][sum + 1];

        //initialize with invcalid values - for eg here it's 2
        for(int i = 0; i < nums.length + 1; i++){
            for(int j = 0; j < sum + 1; j++){
                mat[i][j] = 2;
            }
        }
        return subsetSumTopDown(nums, 0, sum, mat);
    }

    public static int subsetSumTopDown(int[] nums, int index, int sum, int[][] mat){
        if(sum == 0){
            return 1;
        }
        if(index == nums.length){
            return 0;
        }

        //return if already computed values
        if(mat[index][sum] != 2){
            return mat[index][sum];
        }

        if(nums[index] <= sum){
            //include
            int include = subsetSumTopDown(nums, index + 1, sum - nums[index], mat);
            if(include == 1){
                mat[index][sum] = include;
                return 1;
            }
        }
        int exclude = subsetSumTopDown(nums, index + 1, sum, mat);
        return mat[index][sum] = exclude;
    }
}
