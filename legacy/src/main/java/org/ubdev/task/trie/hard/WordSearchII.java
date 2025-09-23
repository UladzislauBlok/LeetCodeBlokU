package org.ubdev.task.trie.hard;

import java.util.LinkedList;
import java.util.List;

class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        for(String word : words) {
            TrieNode insertP = trie;
            for(char c : word.toCharArray()) {
                if (insertP.nodes[c - 'a'] == null) {
                    insertP.nodes[c - 'a'] = new TrieNode();
                }
                insertP = insertP.nodes[c - 'a'];
            }
            insertP.isWord = true;
        }
        List<String> result = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, visited, sb, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int row, int col, TrieNode trie, boolean[][] visited, StringBuilder sb, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return;
        TrieNode currNode = trie.nodes[board[row][col] - 'a'];
        if (visited[row][col] || currNode == null)
            return;
        sb.append(board[row][col]);
        visited[row][col] = true;
        if (currNode.isWord) {
            result.add(sb.toString());
            currNode.isWord = false;
        }
        dfs(board, row - 1, col, currNode, visited, sb, result);
        dfs(board, row + 1, col, currNode, visited, sb, result);
        dfs(board, row, col - 1, currNode, visited, sb, result);
        dfs(board, row, col + 1, currNode, visited, sb, result);
        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private static class TrieNode {
        private final TrieNode[] nodes;
        private boolean isWord;

        TrieNode() {
            nodes = new TrieNode[26];
        }
    }
}
