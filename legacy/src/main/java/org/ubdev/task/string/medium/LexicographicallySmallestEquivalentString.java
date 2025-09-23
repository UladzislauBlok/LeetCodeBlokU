package org.ubdev.task.string.medium;

class LexicographicallySmallestEquivalentString {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind find = new UnionFind(26);
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            int s1c = s1.charAt(i) - 'a';
            int s2c = s2.charAt(i) - 'a';
            find.union(s1c, s2c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int parent = find.find(baseStr.charAt(i) - 'a');
            for (int j = 0; j < 26; j++) {
                if (find.find(j) == parent) {
                    sb.append((char) (j + 'a'));
                    break;
                }
            }
        }
        return sb.toString();
    }

    private static class UnionFind {
        private final int[] parent;

        private UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        private int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return find(parent[i]);
        }

        private void union(int i, int j) {
            int irep = find(i);
            int jrep = find(j);
            parent[irep] = jrep;
        }
    }
}
