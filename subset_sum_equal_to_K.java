package Dynamic_Programming.JAN_DP;

import java.util.Arrays;

public class subset_sum_equal_to_K {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 6;
        System.out.println(subsetSumToK(nums.length, k, nums));
    }

    public static boolean subsetSumToK(int n, int k, int[] arr) {
//        Boolean[][] memo = new Boolean[n + 1][k + 1];
//        return find(0, arr, k, memo);
        //boolean [][] dp = new boolean[n + 1][k + 1];
        boolean[] dp = new boolean[k + 1];

        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= arr[i]; j--) {
                dp[j] = (dp[j] || dp[j - arr[i]]);
            }
        }
        return dp[k];
    }

    static boolean find(int ind, int[] arr, int sum, Boolean[][] memo) {
        if (ind == arr.length) {
            return sum == 0;
        }
        if (memo[ind][sum] != null) {
            return memo[ind][sum];
        }

        // pick
        boolean pick = find(ind + 1, arr, sum - arr[ind], memo);

        // not pick
        boolean notPick = find(ind + 1, arr, sum, memo);
        memo[ind][sum] = pick || notPick;

        return memo[ind][sum];
    }
}