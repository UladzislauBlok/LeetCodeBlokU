package org.ubdev.task.string.medium;

import java.util.HashMap;
import java.util.Map;

public class UsingRobotPrintLexicographicallySmallestString {

    public String robotWithString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder p = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int pointer = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            while (map.getOrDefault(c, 0) > 0 || (!t.isEmpty() && t.charAt(t.length() - 1) == c)) {
                if (!t.isEmpty() && t.charAt(t.length() - 1) == c) {
                    t.deleteCharAt(t.length() - 1);
                    p.append(c);
                } else {
                    char nc = s.charAt(pointer++);
                    t.append(nc);
                    map.put(nc, map.get(nc) - 1);
                }
                while (!t.isEmpty() && t.charAt(t.length() - 1) < c) {
                    char nc = t.charAt(t.length() - 1);
                    t.deleteCharAt(t.length() - 1);
                    p.append(nc);
                }
            }
        }
        for (int i = t.length() - 1; i >= 0; i--) {
            p.append(t.charAt(i));
        }
        return p.toString();
    }
}
