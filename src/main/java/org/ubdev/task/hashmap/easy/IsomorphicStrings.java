package org.ubdev.task.hashmap.easy;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int[] sToT = new int[128];
        int[] tToS = new int[128];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char sC = sArray[i];
            char tC = tArray[i];
            if (sToT[sC] != 0 && sToT[sC] != tC)
                return false;
            sToT[sC] = tC;
            if (tToS[tC] != 0 && tToS[tC] != sC)
                return false;
            tToS[tC] = sC;
        }
        return true;
    }
}
