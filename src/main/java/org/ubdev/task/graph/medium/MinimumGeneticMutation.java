package org.ubdev.task.graph.medium;

import java.util.*;

class MinimumGeneticMutation {
    private final Map<Integer, Set<Character>> map = new HashMap<>();
    private final Set<String> bank = new HashSet<>();
    private int res = Integer.MAX_VALUE;

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (bank.length == 0)
            if (startGene.equals(endGene))
                return 0;
            else
                return -1;
        for (String mutation : bank) {
            this.bank.add(mutation);
            char[] mutationChars = mutation.toCharArray();
            for (int i = 0; i < 8; i++) {
                map.putIfAbsent(i, new HashSet<>());
                map.get(i).add(mutationChars[i]);
            }
        }
        bfs(startGene.toCharArray(), endGene.toCharArray(), 0, new HashSet<>());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    void bfs(char[] startGene, char[] endGene, int counter, Set<String> visited) {
        if (Arrays.equals(startGene, endGene)) {
            res = Math.min(res, counter);
            return;
        }
        for (int i = 0; i < 8; i++) {
            for (Character possibleMutation : map.get(i)) {
                char tmp = startGene[i];
                startGene[i] = possibleMutation;
                String newMutation = new String(startGene);
                if (bank.contains(newMutation) && !visited.contains(newMutation)) {
                    visited.add(newMutation);
                    bfs(startGene, endGene, counter + 1, visited);
                }
                startGene[i] = tmp;
            }
        }
    }
}
