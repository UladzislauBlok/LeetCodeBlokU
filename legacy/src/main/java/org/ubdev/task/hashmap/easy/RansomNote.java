package org.ubdev.task.hashmap.easy;

import java.util.HashMap;
import java.util.Map;

class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : ransomNote.toCharArray()) {
            arr[c - 'a']--;
        }
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i : arr) {
            if (i < 0)
                return false;
        }
        return true;
    }

    public boolean canConstructHashMap(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Integer value : map.values()) {
            if (value < 0)
                return false;
        }
        return true;
    }
}
