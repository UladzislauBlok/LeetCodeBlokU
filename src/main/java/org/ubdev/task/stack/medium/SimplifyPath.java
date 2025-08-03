package org.ubdev.task.stack.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SimplifyPath {

    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        int len = path.length();
        int i = 0;
        while (i < len) {
            while (i < len && path.charAt(i) == '/') {
                i++;
            }
            if (i == len)
                break;
            int j = i;
            while (j < len && path.charAt(j) != '/') {
                j++;
            }
            String sub = path.substring(i, j);
            if (sub.equals("..") && !list.isEmpty())
                list.removeLast();
            if (!sub.equals(".") && !sub.equals(".."))
                list.add(sub);
            i = j;
        }
        return "/" + String.join("/", list);
    }

    public String simplifyPathEasy(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String dir : path.split("/")) {
            if (!stack.isEmpty() && dir.equals("..")) {
                stack.removeLast();
            } else if (!dir.equals(".") && !dir.equals("") && !dir.equals("..")) {
                stack.addLast(dir);
            }
        }
        StringBuilder simplified_path = new StringBuilder();
        for (String dir : stack) {
            simplified_path.append("/").append(dir);
        }
        return simplified_path.length() == 0 ? "/" : simplified_path.toString();
    }
}
