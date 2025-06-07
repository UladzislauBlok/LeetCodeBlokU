package org.ubdev.task.string.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LexicographicallyMinimumStringAfterRemovingStars {

    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.c == p2.c ? p2.pos - p1.pos : p1.c - p2.c);
        Set<Integer> d = new HashSet<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                Pair r = pq.poll();
                d.add(r.pos);
            } else {
                pq.offer(new Pair(c, i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '*' && !d.contains(i)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private record Pair(Character c, Integer pos) {
    }
}
