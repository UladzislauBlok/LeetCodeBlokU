package org.ubdev.task._3227;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topic;
import org.ubdev.util.Topics;

@LeetCodeName("Vowels Game in a String")
@Topics({Topic.MATH})
class Solution {

    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u':
                    return true;
            }
        }
        return false;
    }
}
