package Dynamic_Programming.JAN_DP;

import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        // Create a 2D array
        int numRows = triangle.size();
        int[][] matrix = new int[numRows][];

        // Copy values from the triangle list to the matrix
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = triangle.get(i);
            int numCols = row.size();
            matrix[i] = new int[numCols];
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = row.get(j);
            }
        }
        System.out.println(minimumPathSum(matrix, matrix.length));
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        int[][] dp = new int[triangle.length][triangle.length];
        //Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(0, 0, triangle, dp);
    }

    private static int solve(int r, int c, int[][] mat, int[][] memo) {
//        if (r == mat.length - 1) {
//            return mat[mat.length - 1][c];
//        }
//        if (dp[r][c] != -1) {
//            return dp[r][c];
//        }
        int n=mat.length;
        int[]dp=new int[n];
        System.arraycopy(mat[n - 1], 0, dp, 0, n);
        for (int i = mat.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(mat[i][j] + dp[j], mat[i][j] + dp[j + 1]);
            }
        }

//        int down = solve(r + 1, c, mat, dp);
//        int diagonal = solve(r + 1, c + 1, mat, dp);
//        return dp[r][c] = Math.min(down, diagonal) + mat[r][c]
        return dp[0];
    }
}
