package Dynamic_Programming.JAN_DP;

import java.util.Arrays;

public class Climbing_Stairs {
    /*public int climbStairs(int n) {   // Rec
        if (n == 0) return 0;
        long two_step = 0;
        long one_step = 0;
        if (n > 2) two_step = 1 + nthStair(n - 2);
        else one_step = 1 + nthStair(n - 1);
        return one_step + two_step;
    }*/
    public static long climbStairs(int n, long[] dp) {    // Memo   -->    remove dp
        if (n <= 1) return 1;
        long prev2=1;   // dp[0] = 1;
        long prev=1;   //dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            long currI=prev2+prev;
            prev2=prev;
            prev=currI;
        }
        return prev;
    }
    public static void main(String[] args) {
        long[] dp = new long[5];
        System.out.println(climbStairs(4, dp));
    }
}
