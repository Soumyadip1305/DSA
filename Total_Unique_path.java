package Dynamic_Programming.JAN_DP;

import java.util.Arrays;

public class Total_Unique_path {
    public static int uniquePaths(int m, int n) {
        // int[][] dp = new int[m + 1][n + 1];

        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            int[] dp1 = new int[n];
            dp1[0] = dp[0];
            for (int j = 1; j < n; j++) {
                if (i > 0) dp1[j] += dp[j];
                dp1[j] += dp1[j - 1];
            }
            dp = dp1;
        }
        return dp[n - 1];

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = obstacleGrid[0][i] == 1 ? 0 : dp[i - 1];
        }
        for (int i = 1; i < m; ++i) {
            if (obstacleGrid[i][0] == 1) dp[0] = 0;
            for (int j = 1; j < n; ++j) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];//   return fun(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid);
    }


    static int fun(int r, int c, int[][] mat) {
        if (r == 0 && c == 0) return 1;
        if (r < 0 || c < 0) return 0;
        int u = 0, l = 0;
        if (mat[r][c] != 1) {
            u += fun(r - 1, c, mat);
            l += fun(r, c - 1, mat);
        }
        return u + l;
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}