package org.bloku.task._7;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Reverse Integer")
@Topics({MATH})
class Solution {

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        boolean negative = false;
        if (x < 0) {
            x *= -1;
            negative = true;
        }
        int prev = -1;
        int res = 0;
        while (x > 0) {
            prev = res;
            res *= 10;
            res += x % 10;
            x /= 10;
            if (res < 0 || res - prev < prev) return 0;
        }
        return negative ? -1 * res : res;
    }
}
