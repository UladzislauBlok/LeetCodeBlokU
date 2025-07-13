package org.ubdev.task.array.medium;

import java.util.Arrays;

public class MaximumMatchingPlayersWithTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length , n = trainers.length;
        int count = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
