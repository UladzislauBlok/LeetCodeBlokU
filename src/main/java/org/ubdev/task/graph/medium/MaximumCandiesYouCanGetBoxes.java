package org.ubdev.task.graph.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class MaximumCandiesYouCanGetBoxes {

    // bfs
    public int maxCandies(int[] status, int[] candies, int[][] keyss, int[][] containedBoxes, int[] initialBoxes) {
        int count = 0;
        Set<Integer> keys = new HashSet<>();
        Set<Integer> boxes = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int box : initialBoxes)
            queue.offer(box);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            boxes.add(curr);
            if (status[curr] == 0 && !keys.contains(curr))
                continue;
            for (int key : keyss[curr]) {
                if (keys.add(key) && boxes.contains(key) && status[key] == 0)
                    queue.offer(key);
            }
            for (int neighbor : containedBoxes[curr])
                queue.offer(neighbor);
            count += candies[curr];
        }
        return count;
    }

    // maxHeap
    public int maxCandiesHeap(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b) -> b.value() - a.value());
        for (int box : initialBoxes) {
            q.add(new Pair<>(box, status[box]));
        }

        int count = 0;
        boolean[] visited = new boolean[status.length];
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int current = p.key();
            if (visited[current]) {
                continue;
            }

            if (status[current] == 1) {
                count += candies[current];
                visited[current] = true;

                int[] key = keys[current];
                for (int i : key) {
                    status[i] = 1;
                }

                int[] otherBoxes = containedBoxes[current];
                for (int i : otherBoxes) {
                    q.add(new Pair<>(i, status[i]));
                }
            }
        }
        return count;
    }

    private record Pair<T1, T2>(T1 key, T2 value) {
    }
}
