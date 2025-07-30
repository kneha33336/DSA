package org.example;

public class KnapsackTopDown {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] wt = new int[]{1, 3, 4, 5};
        int[] val = new int[]{1, 4, 5, 7};
        int W = 7;

        // Call knapsack using recursion
        // Time complexity: O(2^n)
        // Space Complexity: O(n)

        // initialize memo matrix on changing arguments in k/s function
        // each value in the matrix is the ans
        // here changing arguments are index and previousWt
        // index can go from 0 to n - 1
        // W can go from 0 to total knapsack W

        int[][] memo = new int[wt.length][W + 1];

        // initialize memo matrix to something that can never be a valid answer i.e. any invalid ans
        // here let's say -1
        for(int i = 0; i < wt.length; i++){
            for(int j = 0; j < W + 1; j++){
                memo[i][j] = -1;
            }
        }

        int max = knapsack(wt, val, W, 0, memo);

        //print output
        System.out.println("Maximum value of knapsack is: " + max);
    }

    //Here return value of the function is answer
    //Instead of making a global answer variable and updating it, we are returning the ans from the function call
    //current ans is max value from index [0 to index n - 1]
    //Here W is the max weight that the knapsack can hold
    public static int knapsack(int[] wt, int[] val, int W, int index, int[][] memo) {
        if (index == wt.length) {
            return 0;
        }

        //if ans already computed in previous iteration, just return that
        if(memo[index][W] != -1){
            return memo[index][W];
        }

        int currentWt = W - wt[index];
        int currentVal = val[index];

        //initializing answer variable
        int max = 0;

        //include current weight if it follows the constraint
        if (currentWt >= 0) {
            //include in knapsack
            // fxn knapsack(...) will return ans from [index + 1 to n - 1] and knapsack can hold max wt of currentWt now
            int include = knapsack(wt, val, currentWt, index + 1, memo) + currentVal;
            max = Math.max(max, include);
        }
        int exclude = knapsack(wt, val, W, index + 1, memo);
        memo[index][W] = max = Math.max(max, exclude);
        return max;
    }
}