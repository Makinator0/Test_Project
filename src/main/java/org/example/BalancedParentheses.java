package org.example;

import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: "); // Prompt the user to input N
        int n = scanner.nextInt();
        System.out.println("Number of balanced parentheses: " + catalanNumber(n));
    }

    // Function to calculate the nth Catalan number
    public static long catalanNumber(int n) {
        if (n == 0) return 1; // Base case: only one valid expression for N=0
        long[] dp = new long[n + 1]; // Dynamic programming array to store Catalan numbers
        dp[0] = 1; // C(0) = 1
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // Use the recursive formula for Catalan numbers
            }
        }
        return dp[n]; // Return the nth Catalan number
    }
}
