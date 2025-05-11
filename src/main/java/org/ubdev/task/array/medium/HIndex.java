package org.ubdev.task.array.medium;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int idx = citations.length - 1;
        int res = 0;
        while(idx >= 0 && res < citations[idx]) {
            res++;
            idx--;
        }
        return res;
    }
}
