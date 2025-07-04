package org.ubdev.task.bit.manipulation.hard;

import java.util.ArrayList;
import java.util.List;

public class FindKCharacterStringGameII {

    public char kthCharacterList(long k, int[] operations) {
        long powNum = 1;
        int pow = 0;
        while(powNum < k) {
            powNum *= 2;
            pow++;
        }
        powNum /= 2;
        List<Integer> steps = new ArrayList<>();
        while (k > 1) {
            k -= powNum;
            steps.add(pow);
            while (powNum >= k) {
                powNum /= 2;
                pow--;
            }
        }
        long diff = 0;
        for (int step : steps) {
            if (operations[step - 1] == 1)
                diff++;
        }
        diff %= 26;
        return (char) ('a' + diff);
    }

    public char kthCharacter(long k, int[] arr) {
        int c = 0; k--;
        for (int i = 0; k != 0; i++, k >>= 1) c += ((int)(k & 1) & arr[i]);
        return (char)((c % 26) + 'a');
    }
}
