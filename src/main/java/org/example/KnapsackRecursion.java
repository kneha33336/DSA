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
        knapsack(wt, val, W, 0, 0, 0, max);

        //Print output
        System.out.println("Maximum value of knapsack is: " + max[0]);
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
            max[0] = Math.max(max[0], currentVal);
            knapsack(wt, val, W, index + 1, currentWt, currentVal, max);

        }
        knapsack(wt, val, W, index + 1, previousWt, previousVal, max);
    }
}
