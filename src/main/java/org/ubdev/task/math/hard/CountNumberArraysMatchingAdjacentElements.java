package org.ubdev.task.math.hard;

/**
 * LLM generated
 */
public class CountNumberArraysMatchingAdjacentElements {
    // Define the modulo constant as 10^9 + 7
    private static final int MOD = 1_000_000_007;

    /**
     * Calculates (base^exp) % MOD efficiently using modular exponentiation (binary exponentiation).
     *
     * @param base The base number.
     * @param exp  The exponent.
     * @return (base^exp) % MOD.
     */
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD; // Ensure base is within the modulo range from the start

        while (exp > 0) {
            // If exp is odd, multiply base with the current result
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            // Square the base and halve the exponent in each step
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    /**
     * Calculates the modular multiplicative inverse of a number 'n' modulo MOD.
     * Uses Fermat's Little Theorem (n^(MOD-2) % MOD) since MOD is a prime number.
     *
     * @param n The number for which to find the inverse.
     * @return The modular inverse of n.
     */
    private long modInverse(long n) {
        // According to Fermat's Little Theorem, a^(p-2) % p is the modular inverse of a % p,
        // when p is a prime number. Our MOD (10^9 + 7) is prime.
        return power(n, MOD - 2);
    }

    /**
     * Calculates the binomial coefficient C(n, r) (n choose r) modulo MOD.
     * C(n, r) = n! / (r! * (n-r)!) = n! * (r!)^(-1) * ((n-r)!)^(-1) % MOD.
     *
     * @param n The total number of items.
     * @param r The number of items to choose.
     * @return C(n, r) % MOD.
     */
    private long nCr(int n, int r) {
        // Handle invalid combinations immediately
        if (r < 0 || r > n) {
            return 0;
        }
        // C(n, 0) = C(n, n) = 1
        if (r == 0 || r == n) {
            return 1;
        }
        // Optimization: C(n, r) = C(n, n-r). Use the smaller r for calculations.
        if (r > n / 2) {
            r = n - r;
        }

        // Pre-calculate factorials up to n modulo MOD
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // Numerator is n!
        long numerator = fact[n];
        // Denominator is (r! * (n-r)!) % MOD
        long denominator = (fact[r] * fact[n - r]) % MOD;

        // Calculate n! * (denominator)^(-1) % MOD
        return (numerator * modInverse(denominator)) % MOD;
    }

    /**
     * Calculates the number of "good arrays" based on the given criteria.
     * A good array 'arr' of size 'n' has:
     * 1. Each element in the inclusive range [1, m].
     * 2. Exactly 'k' indices 'i' (where 1 <= i < n) satisfy arr[i - 1] == arr[i].
     *
     * @param n The size of the array.
     * @param m The maximum value for elements in the array.
     * @param k The exact number of adjacent equal elements.
     * @return The number of good arrays modulo 10^9 + 7.
     */
    public int numberOfGoodArrays(int n, int m, int k) {
        // Handle edge cases for k
        // k cannot be negative, and it cannot be greater than or equal to n (as there are only n-1 possible pairs)
        if (k < 0 || k >= n) {
            return 0;
        }

        // If n is 1, there are no adjacent pairs, so k must be 0.
        // We have 'm' choices for the single element.
        if (n == 1) {
            return k == 0 ? m % MOD : 0;
        }

        // If m is 1, all elements must be 1. This means all adjacent elements must be equal.
        // So, k must be exactly n-1. If k is not n-1, it's impossible.
        if (m == 1) {
            return k == (n - 1) ? 1 : 0;
        }

        // Step 1: Calculate the number of ways to choose 'k' positions out of 'n-1'
        // where arr[i-1] == arr[i]. This is C(n-1, k).
        long combinations = nCr(n - 1, k);

        // Step 2: Calculate 'm' (choices for the first element) modulo MOD.
        long mVal = m % MOD;

        // Step 3: Calculate (m-1)^(n-1-k) modulo MOD.
        // This represents the choices for the (n-1-k) positions where arr[i-1] != arr[i].
        // If m-1 is 0 (i.e., m is 1), and n-1-k is not 0, then this term would be 0.
        // However, we handle m=1 separately, so m-1 will be >= 1 here.
        long mMinusOnePow = power(m - 1, (n - 1) - k);

        // Step 4: Multiply all calculated parts and take modulo at each multiplication.
        long result = (combinations * mVal) % MOD;
        result = (result * mMinusOnePow) % MOD;

        return (int) result;
    }
}
