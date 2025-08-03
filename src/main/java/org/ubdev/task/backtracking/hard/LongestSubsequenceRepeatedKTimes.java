package org.ubdev.task.backtracking.hard;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class LongestSubsequenceRepeatedKTimes {

    public String longestSubsequenceRepeatedK(String s, int k) {
        String ans = "";
        int[] map = new int[26];
        Queue<String> q = new ArrayDeque<>(List.of("")); //for first case "" + first char
        for (char c : s.toCharArray())
            map[c - 'a']++;

        for (char c = 'a'; c <= 'z'; c++) {
            if (map[c - 'a'] < k)
                map[c - 'a'] = 0;
            else
                q.offer(String.valueOf(c));
        }

        while (!q.isEmpty()) {
            String subSeq = q.poll();
            for (char c = 'a'; c <= 'z'; c++) {
                if (map[c - 'a'] == 0)
                    continue;
                String newSubSeq = subSeq + c;
                if (isSubsequence(newSubSeq, s, k)) {
                    q.offer(newSubSeq);
                    ans = newSubSeq;
                }
            }
        }
        return ans;
    }

    private boolean isSubsequence(String subSeq, String s, int k) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == subSeq.charAt(i)) {
                if (++i == subSeq.length()) {
                    if (--k == 0)
                        return true;
                    i = 0;
                }
            }
        }
        return false;
    }
}
