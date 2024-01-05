package Dynamic_Programming.JAN_DP;

import java.util.*;

public class House_Rob_II {
    public static long houseRobber(int[] valueInHouse) {
        ArrayList<Long> temp = new ArrayList<>();
        ArrayList<Long> temp2 = new ArrayList<>();
        long n = valueInHouse.length;
        if (n == 1) {
            return valueInHouse[0];
        }
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                temp.add((long) valueInHouse[i]);
            }
            if (i != n - 1) {
                temp2.add((long) valueInHouse[i]);
            }
        }
        return Math.max(solve(temp), solve(temp2));
    }

    private static long solve(ArrayList<Long> list) {
        long prev = list.get(0);
        long prev2 = 0;
        for (int i = 1; i < list.size(); i++) {
            long curr = Math.max(list.get(i) + prev2, prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
