package org.ubdev.task.string.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        int length = 0;
        int unequalLength = 0;
        for (String word : wordMap.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
                int count = wordMap.get(word);
                if (length % 2 == 0) { //  counting occurrence of palindromes
                    length += count;
                } else {
                    length += 2 * (count / 2);
                }
            } else {
                String palindromicWord = new StringBuilder(word).reverse().toString();
                unequalLength += Math.min((int) wordMap.get(word), (int) wordMap.getOrDefault(palindromicWord, 0)) * 4; // num of occurrence * length
                wordMap.put(word, 0);
            }
        }
        return unequalLength + length * 2;
    }
}
