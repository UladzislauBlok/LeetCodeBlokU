package org.ubdev.task.string.easy;

public class FindKCharacterStringGameI {

    public char kthCharacter(int k) {
        long pow = 1;
        int count = 0;
        while(pow < k) {
            pow *= 2;
            count++;
        }
        pow /= 2;
        int diff = count;
        while (k > 1) {
            k -= pow; // it's safe here because of lines 6 and 10
            diff--;
            while (pow >= k)
                pow /= 2;
        }
        diff = count - diff; // offset
        diff %= 26;
        return (char) ('a' + diff);
    }

    public char kthCharacterBits(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }
}
