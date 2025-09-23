package org.ubdev.task.trie.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DeleteDuplicateFoldersSystem {

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Map<Integer, List<Trie>> map = new HashMap<>();
        Trie trie = new Trie("/");
        for (List<String> path : paths) {
            trie.addPath(path, 0);
        }
        trie.checkForCollision(map);
        trie.removeCollisions();
        List<List<String>> result = new ArrayList<>();
        trie.asList(result);
        return result;
    }

    private static class Trie {
        private final Map<String, Trie> children = new HashMap<>();
        private final String title;

        private boolean toRemove;

        private Trie(String title) {
            this.title = title;
        }

        private void addPath(List<String> path, int idx) {
            if (idx == path.size())
                return;
            String nextTitle = path.get(idx);
            if (!children.containsKey(nextTitle)) {
                children.put(nextTitle, new Trie(nextTitle));
            }
            children.get(nextTitle).addPath(path, idx + 1);
        }

        private void checkForCollision(Map<Integer, List<Trie>> map) {
            if (children.isEmpty())
                return;
            int hash = hashCode();
            if (map.containsKey(hash)) {
                for (Trie trie : map.get(hash)) {
                    if (trie.equals(this)) {
                        this.toRemove = true;
                        trie.toRemove = true;
                        return;
                    }
                }
            } else {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(this);
            for (Trie child : children.values()) {
                child.checkForCollision(map);
            }
        }

        private void removeCollisions() {
            List<String> removeList = new ArrayList<>();
            for (Trie child : children.values()) {
                if (child.toRemove) {
                    removeList.add(child.title);
                } else {
                    child.removeCollisions();
                }
            }
            for (String keys : removeList) {
                children.remove(keys);
            }
        }

        private void asList(List<List<String>> result) {
            List<String> curr = new ArrayList<>();
            for (Trie child : children.values()) {
                if (!child.toRemove)
                    child.asList(result, curr);
            }
        }

        private void asList(List<List<String>> result, List<String> curr) {
            curr.add(title);
            result.add(new ArrayList<>(curr));
            for (Trie child : children.values()) {
                if (!child.toRemove)
                    child.asList(result, curr);
            }
            curr.removeLast();
        }

        // For debugging
        @Override
        public String toString() {
            return "Trie {Title: " + title + "; To be removed: " + toRemove + "; Children: " + children.values()+"}";
        }

        @Override
        public int hashCode() {
            return children.hashCode();
        }

        // For hash collision case
        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (obj instanceof Trie trie) {
                return this.children.equals(trie.children);
            }
            return false;
        }
    }
}
