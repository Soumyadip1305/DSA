package Dynamic_Programming.JAN_DP;

import java.util.*;

public class maximum_sum_non_adj {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>(List.of(1, 2, 3, 1));
        int[]nums = {2,3,-2,4};
        System.out.println(rob(nums));
        //System.out.println(maximumNonAdjacentSum(myList));
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        if (nums.size() == 2) return Math.max(nums.get(0), nums.get(1));
        int[] dp = new int[nums.size() + 1];
        // Arrays.fill(dp,-1);
        return solve(nums, nums.size() - 1, dp);
    }

    static int solve(ArrayList<Integer> list, int ind, int[] dp) {
        int prev = list.get(0);
        int prev2 = 0;
        for (int i = 1; i < list.size(); i++) {
//            int pick = 0;
//                pick = list.get(i) + prev2;
//            int not_pick = prev;
            int curr = Math.max(list.get(i) + prev2, prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static int rob(int[] nums) {
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(nums[i] * prev2, prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
