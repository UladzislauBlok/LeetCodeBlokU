package org.ubdev.task.tree.medium;

class DesignAddSearchWordsDataStructure {

    public static class WordDictionary {
        private final Node[] nodes;

        public WordDictionary() {
            this.nodes = new Node[26];
        }

        public void addWord(String word) {
            char[] wordChars = word.toCharArray();
            int charPos = wordChars[0] - 'a';
            Node node = nodes[charPos] == null ? nodes[charPos] = new Node(wordChars[0]) : nodes[charPos];
            node.addWord(wordChars, 1);
        }

        public boolean search(String word) {
            char[] wordChars = word.toCharArray();
            if (wordChars[0] == '.')
                return checkAll(wordChars);
            int charPos = wordChars[0] - 'a';
            if (nodes[charPos] == null)
                return false;
            return nodes[charPos].search(wordChars, 1);
        }

        private boolean checkAll(char[] word) {
            for (Node node : nodes) {
                if (node != null && node.search(word, 1))
                    return true;
            }
            return false;
        }
    }
}

class Node {
    final char value;
    final Node[] nodes;
    boolean isWord;

    Node(char value) {
        this.value = value;
        this.nodes = new Node[26];
    }

    void addWord(char[] word, int pos) {
        if (pos == word.length) {
            isWord = true;
            return;
        }
        int charPos = word[pos] - 'a';
        Node node = nodes[charPos] == null ? nodes[charPos] = new Node(word[pos]) : nodes[charPos];
        node.addWord(word, pos + 1);
    }

    boolean search(char[] word, int pos) {
        if (pos == word.length)
            return isWord;
        if (word[pos] == '.') {
            return checkAll(word, pos);
        }
        int charPos = word[pos] - 'a';
        if (nodes[charPos] == null)
            return false;
        return nodes[charPos].search(word, pos + 1);
    }

    boolean checkAll(char[] word, int pos) {
        for (Node node : nodes) {
            if (node != null && node.search(word, pos + 1))
                return true;
        }
        return false;
    }
}
