package org.ubdev.task.hashmap.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            int sum = 0;
            set.add(n);
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (sum == 1)
                return true;
            n = sum;
        }
        return false;
    }
}
