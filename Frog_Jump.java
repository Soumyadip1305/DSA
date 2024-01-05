package Dynamic_Programming.JAN_DP;

import java.util.Arrays;

public class Frog_Jump {
    public static void main(String[] args) {
        System.out.println(frogJump(4, new int[]{10, 20,30, 10}));
    }

    public static int frogJump(int n, int[] arr) {
        //int[] dp = new int[n + 1];
       // Arrays.fill(dp, -1);
        //return solve(heights, n - 1, dp);
        //dp[0]= arr[0];
        int prev=0,prev2=0;
        for (int i = 1; i <n ; i++) {
            int take1 = prev + Math.abs(arr[i] - arr[i - 1]), take2 = arr[0];
            if (i > 1) {
                take2 =prev2 + Math.abs(arr[i] - arr[i - 2]);
            }
            int currI= Math.min(take1, take2);
            prev2=prev;
            prev=currI;
        }
        return prev;
    }

    static int solve(int[] arr, int ind, int[] dp) {   // memoization ----> Tabulation
       int take1 = solve(arr, ind - 1, dp) + Math.abs(arr[ind] - arr[ind - 1]), take2 = arr[arr.length - 1];
        if (ind > 1) {
            take2 = solve(arr, ind - 2, dp) + Math.abs(arr[ind] - arr[ind - 2]);
        }
        return dp[ind] = Math.min(take1, take2);
    }
}
