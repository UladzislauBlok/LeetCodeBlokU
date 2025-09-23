package org.ubdev.task.hashmap.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RearrangingFruits {

    // greedy kind of
    // Build amp for both
    // Find diff and devide by 2 = times element should be moved
    // if diff%2==1 return -1;
    // We can move num directly or use min number (even if we don't have to move it)
    public long minCostTwoMap(int[] basket1, int[] basket2) {
        int n = basket1.length;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map1.put(basket1[i], map1.getOrDefault(basket1[i], 0)+1);
            map2.put(basket2[i], map2.getOrDefault(basket2[i], 0)+1);
            min = Math.min(min, Math.min(basket1[i], basket2[i]));
        }
        List<Integer> list1 = new ArrayList<>();
        for (int key : map1.keySet()) {
            int diff = map1.get(key) - map2.getOrDefault(key, 0);
            if (diff <= 0)
                continue;
            if ((diff&1) == 1)
                return -1;
            for (int i = 0; i < diff/2; i++)
                list1.add(key);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int key : map2.keySet()) {
            int diff = map2.get(key) - map1.getOrDefault(key, 0);
            if (diff <= 0)
                continue;
            if ((diff&1) == 1)
                return -1;
            for (int i = 0; i < diff/2; i++)
                list2.add(key);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        long res = 0;
        for (int num1 : list1) {
            res += Math.min(min*2, Math.min(num1, list2.getLast()));
            list2.removeLast();
        }
        return res;
    }

    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(basket1[i], map.getOrDefault(basket1[i], 0)+1); // +1
            map.put(basket2[i], map.getOrDefault(basket2[i], 0)-1); // -1 it's to find the diff
            min = Math.min(min, Math.min(basket1[i], basket2[i]));
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int diff = Math.abs(entry.getValue());
            if ((diff&1) == 1)
                return -1;
            for (int i = 0; i < diff/2; i++)
                list.add(entry.getKey());
        }
        Collections.sort(list);
        long res = 0;
        for (int i = 0; i < list.size()/2; i++) {
            res += Math.min(min*2, list.get(i));
        }
        return res;
    }
}
