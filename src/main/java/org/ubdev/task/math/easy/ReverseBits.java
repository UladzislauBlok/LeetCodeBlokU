package org.ubdev.task.math.easy;

public class ReverseBits {

    // You need to treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        // Iterate through all 32 bits of the number
        for (int i = 0; i < 32; i++) {
            // Get the least significant bit (LSB) of n
            int bit = n & 1;

            // Shift the result to the left by 1 position to make room for the new bit
            result <<= 1;

            // Add the extracted bit to result
            result |= bit;

            // Shift n to the right by 1 position to process the next bit
            n >>= 1;
        }

        return result;
    }
}
