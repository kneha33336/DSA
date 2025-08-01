package org.example.Knapsack;

public class KnapsackBottomUp {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] wt = new int[]{1, 3, 4, 5};
        int[] val = new int[]{1, 4, 5, 7};
        int W = 7;

        // Bottom up approach
        // Call stack exception won't come, like just in case
        // Time complexity: O(n * W) -> here n is the val.length
        // Space Complexity: O(n * W)

        // initialize memo matrix on changing arguments in k/s function
        // each value in the matrix is the ans
        // here changing arguments are index and W
        // index can go from 0 to n
        // W can go from 0 to total knapsack W

        int[][] memo = new int[wt.length + 1][W + 1];

        // initialize memo matrix's with base condition of recursion

        //if wt.length == n, change W(cols) in loop
        for(int j = 0; j < W + 1; j++){
            //last row
            memo[wt.length][j] = 0;
        }

        //if W == 0, change wt.length(rows) in loop
        for(int i = 0; i < wt.length + 1; i++){
            //first col
            memo[i][0] = 0;
        }

        //Knapsack bottom up approach code

        //global maxima of all answers
        int max = 0;
        for(int i = wt.length - 1; i >= 0; i--){
            for(int j = 1; j < W + 1; j++){
                System.out.println("i, j is " + i + " " + j);
                int ans = 0;
                //include with constraint
                //i is indexes of (wt, val) arr and j is W
                if(wt[i] <= j){
                    int include = ans = val[i] + memo[i + 1][j - wt[i]];
                    System.out.println("included ans " + include);
                }

                //always exclude
                int exclude = memo[i + 1][j];
                System.out.println("excluded ans " + exclude);

                ans = Math.max(ans, exclude);

                //Store ans
                memo[i][j] = ans;
                System.out.println("ans is " + ans);

                //Updating global maximum answer
                max = Math.max(max, ans);
                System.out.println("global max is " + max);
            }
        }

        //print output
        System.out.println("Maximum value of knapsack is: " + max);
    }
}
