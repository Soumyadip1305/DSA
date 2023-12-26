package Dynamic_Programming.JAN_DP;

import java.util.Arrays;

public class Nth_fibo {
    public static void main(String[] args) {
        System.out.println(nthFibonacci(8));
    }

    static int nthFibonacci(int n) {
        int m=1000000007;
        int prev=1, prev2=0;
        int curI=0;
        for (int i = 2; i <=n ; i++) {
             curI=(prev+prev2)%m;
            prev2=prev;
            prev=curI;
        }
        return curI;
    }
}
