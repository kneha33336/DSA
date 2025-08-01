package org.example.TargetSum;

public class TargetSumBottomUp {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] nums = new int[]{3, 34, 4, 12, 5, 2};
        int sum = 9;
        int ans = subsetSumBottomUp(nums, sum);
        System.out.printf("TargetSumBottomUp ans: " + ans);
    }

    public static int subsetSumBottomUp(int[] nums, int sum){
        int[][] mat = new int[nums.length + 1][sum + 1];

        //sum == 0
        for(int i = 0; i < nums.length + 1; i++){
            mat[i][0] = 1;
        }

        //index == nums.length
        //j starts from 1 as when mat[nums.length][0] is 1
        for(int j = 1; j < sum + 1; j++){
            mat[nums.length][j] = 0;
        }

        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 1; j < sum + 1; j++){
                if(nums[i] <= j){
                    mat[i][j] = mat[i + 1][j - nums[i]];
                    if(mat[i][j] == 1){
                        //you can return 1 from here also and get done
                        continue;
                    }
                }
                mat[i][j] = mat[i + 1][j];
            }
        }

        //very important
        return mat[0][sum];
    }
}
