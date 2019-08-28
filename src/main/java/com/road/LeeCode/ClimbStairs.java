package com.road.LeeCode;

/**
 * 
 */
public class ClimbStairs {
    public static void main(String[] args) {
        new ClimbStairs().climbStairs(5);
    }

    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    public int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }
}
