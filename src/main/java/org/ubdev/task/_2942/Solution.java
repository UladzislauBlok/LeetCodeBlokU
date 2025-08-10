package org.ubdev.task._2942;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import java.util.ArrayList;
import java.util.List;

import static org.ubdev.util.Topic.*;

@LeetCodeName("Find Words Containing Character")
@Topics({ARRAY, STRING})
class Solution {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].indexOf(x) != -1)
                res.add(i);
        }
        return res;
    }
}
