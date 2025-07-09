package org.ubdev.task.sliding.window.medium;

public class RescheduleMeetingsMaximumFreeTimeI {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int max = Integer.MIN_VALUE;
        int right = startTime[0] == 0 ? startTime[1] : startTime[0]; // first window
        int left = startTime[0] == 0 ? endTime[0] : 0;
        int window = right - left;
        int idxR = startTime[0] == 0 ? 1 : 0;
        int idxL = startTime[0] == 0 ? 0 : -1;
        while (right < eventTime) {
            if (k == 0) {
                int temp = left;
                left = endTime[++idxL];
                window -= (startTime[idxL] - temp);
                k++;
            }
            if (idxR < n - 1) {
                right = startTime[++idxR];
                window += (right - endTime[idxR - 1]);
            } else {
                right = eventTime; // end
                window += (right - endTime[n - 1]);
            }
            k--;
            max = Math.max(max, window);
        }
        return max;
    }

    /*
    1. Combine the biggest one
    2. We can combine only k closest
    3. Going through using lsiding windown, check k and Math.max(max, window)
    */
}
