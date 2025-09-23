package org.ubdev.task.dynamic.programming;

class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        //full s1 == s3
        int i = 1;
        while (dp[0][i - 1] && i <= s2.length()) {
            dp[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1);
            i++;
        }
        //full s1 == s3
        int j = 1;
        while (dp[j - 1][0] && j <= s1.length()) {
            dp[j][0] = s1.charAt(j - 1) == s3.charAt(j - 1);
            j++;
        }
        // check mixed
        for (i = 1; i <= s1.length(); i++) {
            for (j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
