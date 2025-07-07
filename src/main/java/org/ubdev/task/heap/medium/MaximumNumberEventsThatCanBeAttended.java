package org.ubdev.task.heap.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

class MaximumNumberEventsThatCanBeAttended {

    public int maxEventsPqs(int[][] events) {
        boolean[] visited = new boolean[events.length];
        PriorityQueue<Pair> pqS = new PriorityQueue<>((a, b) -> a.event[0] - b.event[0] == 0 ?
                a.event[1] - b.event[1] : a.event[0] - b.event[0]);
        PriorityQueue<Pair> pqE = new PriorityQueue<>((a,b) -> a.event[1] - b.event[1] == 0 ?
                a.event[0] - b.event[0] : a.event[1] - b.event[1]);
        int day = 1;
        int count = 0;
        for (int i = 0; i < events.length; i++) {
            pqS.offer(new Pair(events[i], i));
            pqE.offer(new Pair(events[i], i));
        }
        while (!pqS.isEmpty() && !pqE.isEmpty()) {
            // System.out.println(day);
            while (!pqS.isEmpty() && visited[pqS.peek().idx] || !pqS.isEmpty() && pqS.peek().event[1] < day)
                pqS.poll();
            while (!pqE.isEmpty() && visited[pqE.peek().idx] || !pqE.isEmpty() && pqE.peek().event[1] < day)
                pqE.poll();
            if (!pqE.isEmpty() && pqE.peek().event[0] <= day) {
                day++;
                count++;
                visited[pqE.poll().idx] = true;
            } else if (!pqS.isEmpty() && pqS.peek().event[0] <= day) {
                day++;
                count++;
                visited[pqS.poll().idx] = true;
            } else if (!pqS.isEmpty() && pqS.peek().event[0] > day) {
                day = pqS.peek().event[0];
            }
        }
        return count;
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int day = 0, index = 0 , n = events.length ,result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (!pq.isEmpty() || index < n) {
            if (pq.isEmpty()) {
                day = events[index][0];
            }
            while (index < n && events[index][0] <= day) {
                pq.offer(events[index][1]);
                index++;
            }
            pq.poll();
            result++;
            day++;

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }
        return result;
    }

    private static class Pair {
        private final int[] event;
        private final int idx;

        private Pair(int[] event, int idx) {
            this.event = event;
            this.idx = idx;
        }
    }
}
