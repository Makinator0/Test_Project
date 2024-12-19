package org.example;

import java.math.BigInteger;

public class FactorialDigitSum {
    public static void main(String[] args) {
        int number = 100; // The number to calculate the factorial of
        BigInteger factorial = calculateFactorial(number); // Calculate 100!
        int digitSum = calculateDigitSum(factorial); // Find the sum of the digits
        System.out.println("The sum of digits in " + number + "! is: " + digitSum);
    }

    // Function to calculate the factorial of a number using BigInteger
    public static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE; // Initialize factorial as 1
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i)); // Multiply iteratively
        }
        return result; // Return the factorial
    }

    // Function to calculate the sum of the digits in a BigInteger
    public static int calculateDigitSum(BigInteger number) {
        int sum = 0;
        String digits = number.toString(); // Convert the number to a string
        for (char c : digits.toCharArray()) { // Iterate through each digit
            sum += Character.getNumericValue(c); // Add the numeric value of the digit to the sum
        }
        return sum; // Return the total sum of digits
    }
}


