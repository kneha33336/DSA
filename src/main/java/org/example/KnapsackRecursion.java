package org.example;

public class KnapsackRecursion {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        //Insert the input here
        int[] wt = new int[]{1, 3, 4, 5};
        int[] val = new int[]{1, 4, 5, 7};
        int W = 7;
        int[] max = new int[1];

        //Call knapsack using recursion
        //Time complexity: O(2^n)
        //Space Complexity: O(n)

        //Method1
        knapsack(wt, val, W, 0, 0, 0, max);

        //Print output
        System.out.println("Maximum value of knapsack using method 1 is: " + max[0]);

        //Method2
        int ans = knapsack(wt, val, W, 0);

        //Print output
        System.out.println("Maximum value of knapsack using method 2 is: " + ans);
    }

    public static void knapsack(int[] wt, int[] val, int W, int index, int previousWt, int previousVal, int[] max){
        if(index == wt.length){
            return;
        }

        int currentWt = previousWt + wt[index];
        int currentVal = previousVal + val[index];

        //include current weight if it follows the constraint
        if(currentWt <= W){
            //include in knapsack
            knapsack(wt, val, W, index + 1, currentWt, currentVal, max);
            max[0] = Math.max(max[0], currentVal);
        }
        knapsack(wt, val, W, index + 1, previousWt, previousVal, max);
    }

    //Here return value of the function is answer
    //Instead of making a global answer variable and updating it, we are returning the ans from the function call
    //current ans is max value from index [0 to index n - 1]
    //Here W is the max weight that the knapsack can hold
    public static int knapsack(int[] wt, int[] val, int W, int index) {
        if (index == wt.length) {
            return 0;
        }

        int currentWt = W - wt[index];
        int currentVal = val[index];

        //initializing answer variable
        int max = 0;

        //include current weight if it follows the constraint
        if (currentWt >= 0) {
            //include in knapsack
            // fxn knapsack(...) will return ans from [index + 1 to n - 1] and knapsack can hold max wt of currentWt now
            int include = knapsack(wt, val, currentWt, index + 1) + currentVal;
            max = Math.max(max, include);
        }
        int exclude = knapsack(wt, val, W, index + 1);
        max = Math.max(max, exclude);
        return max;
    }
}