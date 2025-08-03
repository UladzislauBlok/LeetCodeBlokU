package org.ubdev.task.array.medium;

import java.util.Arrays;
import java.util.Comparator;

class CountDaysWithoutMeetings {

    public int countDaysQuick(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        int lastUpdated = 0;
        int freeDays = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (meetings[i][0] > lastUpdated) {
                freeDays += meetings[i][0] - lastUpdated - 1;
            }
            lastUpdated = Math.max(lastUpdated, meetings[i][1]);
        }
        return freeDays + days - lastUpdated;
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int lastUpdated = 0;
        int freeDays = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > lastUpdated) {
                freeDays += meeting[0] - lastUpdated - 1;
            }
            lastUpdated = Math.max(lastUpdated, meeting[1]);
        }
        return freeDays + days - lastUpdated;
    }
}
