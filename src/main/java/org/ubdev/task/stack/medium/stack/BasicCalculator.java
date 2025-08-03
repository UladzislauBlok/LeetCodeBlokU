package org.ubdev.task.stack.medium.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class BasicCalculator {

    public int calculateB(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            if (s.charAt(right) == '(' || s.charAt(right) == '+' || s.charAt(right) == '-') {
                stack.push(s.substring(right, right + 1));
            } else if (s.charAt(right) == ')') {
                stack.push(String.valueOf(calculate(stack)));
            } else if (s.charAt(right) != ' ') {
                left = right;
                while (right < s.length() && s.charAt(right) != ' ' && s.charAt(right) != '(' && s.charAt(right) != ')' && s.charAt(right) != '+' && s.charAt(right) != '-') {
                    right++;
                }
                stack.push(s.substring(left, right));
                right--;
            }
            right++;
        }
        return calculate(stack);
    }

    private int calculate(Deque<String> stack) {
        List<String> list = new LinkedList<>();
        while (!stack.isEmpty() && !stack.peek().equals("(")) {
            list.addFirst(stack.pop());
        }
        if (!stack.isEmpty() && stack.peek().equals("("))
            stack.pop();
        boolean negativeNum = false;
        int sum = 0;
        for (String str : list) {
            if (str.equals("-")) {
                negativeNum = true;
            } else if (str.equals("+")) {
                negativeNum = false;
            } else {
                int num = Integer.parseInt(str);
                if (negativeNum) {
                    sum -= num;
                } else {
                    sum += num;
                }
            }
        }
        return sum;
    }

    public int calculate(String s) { // better
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int sign = 1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                result += sign * num;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result *= stack.pop();
                result += stack.pop();
            }
        }
        return result;
    }
}
