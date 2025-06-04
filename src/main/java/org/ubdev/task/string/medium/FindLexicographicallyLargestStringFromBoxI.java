package org.ubdev.task.string.medium;

public class FindLexicographicallyLargestStringFromBoxI {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;
        int n = word.length();
        String res = "";
        int length = n - numFriends + 1;
        for (int i = 0; i < n; i++) {
            String temp = word.substring(i, Math.min(n, i + length));
            if (temp.compareTo(res) > 0)
                res = temp;
        }
        return res;
    }
}
