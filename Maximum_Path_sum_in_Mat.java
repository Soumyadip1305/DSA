package Dynamic_Programming.JAN_DP;

public class Maximum_Path_sum_in_Mat {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 10, 4}, {100, 3, 2, 1}, {1, 1, 20, 2}, {1, 2, 2, 1}};
        System.out.println(getMaxPathSum(mat));
    }

    public static int getMaxPathSum(int[][] mat) {
//        int maxi = 0;
//        for (int j = 0; j < mat[0].length; j++) {
//            int ans = sum(mat.length - 1, j, mat);
//            maxi = Math.max(maxi, ans);
//        }
//        return maxi;
//    }
//
//    static int sum(int r, int c, int[][] mat) {
//        if (c < 0 || c >= mat[0].length) {
//            return Integer.MIN_VALUE;
//        }
//        if (r == 0) {
//            return mat[0][c];
//        }
        int n=mat.length,m=mat[0].length;
        int[]dp=new int[m];
        System.arraycopy(mat[0], 0, dp, 0, mat[0].length);
        for (int r = 1; r < n; r++) {
            int []prev=new int[m];
            for (int c = 0; c < m; c++) {
               prev[c]= mat[r][c] +Math.max(dp[ c], Math.max((c - 1 >= 0) ? dp[c - 1] : Integer.MIN_VALUE, (c + 1 < mat[0].length) ?  dp[c + 1] : Integer.MIN_VALUE));
            }
            dp=prev;
        }
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[j]);
        }

        return maxi;
//        int straight = mat[r][c] + sum(r - 1, c, mat);
//        int ld = mat[r][c] + sum(r - 1, c - 1, mat);
//        int rd = mat[r][c] + sum(r - 1, c + 1, mat);
//        return Math.max(straight, Math.max(ld, rd));
    }
}
