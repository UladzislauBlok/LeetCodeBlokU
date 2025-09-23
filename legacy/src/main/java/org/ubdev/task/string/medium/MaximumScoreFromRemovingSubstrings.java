package org.ubdev.task.string.medium;

import java.util.ArrayDeque;
import java.util.Deque;

class MaximumScoreFromRemovingSubstrings {

    public int maximumGain(String s, int x, int y) {
        Deque<Character> stack = new ArrayDeque<>();
        String find = x > y ? "ab" : "ba";
        int rev = Math.max(x, y);
        int sum = 0;
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= 2) {
                char c2 = stack.pop();
                char c1 = stack.pop();
                if (find.charAt(0) == c1 && find.charAt(1) == c2) {
                    sum += rev;
                } else {
                    stack.push(c1); // correct order is important here
                    stack.push(c2);
                }
            }
        }
        find = x < y ? "ab" : "ba";
        rev = Math.min(x, y);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.getLast());
            stack.removeLast(); // It's deque ;)
        }
        s = sb.toString();
//        System.out.println(s); // What's left
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= 2) {
                char c2 = stack.pop();
                char c1 = stack.pop();
                if (find.charAt(0) == c1 && find.charAt(1) == c2) {
                    sum += rev;
                } else {
                    stack.push(c1); // correct order is important here
                    stack.push(c2);
                }
            }
        }
        return sum;
    }

    // O(n^3) don't think it will pass
    public int maximumGainBad(String s, int x, int y) {
        String find = x > y ? "ab" : "ba";
        int rev = Math.max(x, y);
        int sum = 0;
        while (s.contains(find)) {
            int idx = s.indexOf(find);
            s = s.substring(0, idx) + s.substring(idx + 2);
            sum += rev;
        }
        find = x < y ? "ab" : "ba";
        rev = Math.min(x, y);
        while (s.contains(find)) {
            int idx = s.indexOf(find);
            s = s.substring(0, idx) + s.substring(idx + 2);
            sum += rev;
        }
        return sum;
    }
}
