package Dynamic_Programming.JAN_DP;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        //Integer[][] dp = new Integer[grid.length][grid[0].length];
        int[][] dp = new int[grid.length][grid[0].length];
        System.out.println(sum(grid.length, grid[0].length, grid, dp));
    }
    public int minPathSum(int[][] grid) {
        //Integer[][] dp = new Integer[grid.length][grid[0].length];
        int[][] dp = new int[grid.length][grid[0].length];
        return sum(grid.length, grid[0].length, grid, dp);
    }

    static int sum(int r, int c, int[][] mat, int[][] memo) {  // rec-->memo-->tabu
//        if (r == 0 && c == 0) return mat[0][0];
//        if (r < 0 || c < 0) return Integer.MAX_VALUE;
//        if (dp[r][c] != null) return dp[r][c];
//        int left = sum(r - 1, c, mat, dp);
//        int right = sum(r, c - 1, mat, dp);
//        return dp[r][c] = Math.min(left, right) + mat[r][c];
        memo[0][0] = mat[0][0];
//        for (int j = 1; j < mat[0].length; j++) {
//            dp[0][j] = dp[0][j - 1] + mat[0][j];
//        }
        int[] dp = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            dp[0] += mat[i][0];
            for (int j = 1; j < mat[0].length; j++) {
                dp[j] =(i == 0)? dp[j - 1] + mat[0][j]:
                        Math.min(dp[j], dp[j - 1]) + mat[i][j];
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[mat[0].length - 1];
    }
}
