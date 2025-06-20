package org.ubdev.task.string.medium;

import java.util.HashMap;
import java.util.Map;

class MaximumManhattanDistanceAfterKChanges {

    // N neutralize S
    // E neutralize W
    // Max win of 1 change is +2
    // Max win of all changes is k * +2
    // Max win on curr step is min of 2*k and lost income (curr step - distance)
    public int maxDistanceMap(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('N', 0);
        map.put('S', 0);
        map.put('E', 0);
        map.put('W', 0);
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) + 1);
            int dist = Math.abs(map.get('N') - map.get('S')) + Math.abs(map.get('E') - map.get('W'));
            res = Math.max(res, dist + Math.min(2*k, i + 1 - dist));
        }
        return res;
    }

    public int maxDistance(String str, int k) {
        int n = 0, s = 0, e = 0, w = 0, max = 0;
        for (char c : str.toCharArray()) {
            n += c == 'N' ? 1 : 0;
            s += c == 'S' ? 1 : 0;
            e += c == 'E' ? 1 : 0;
            w += c == 'W' ? 1 : 0;
            int y = Math.min(k, Math.min(n, s)); // find min to be changed
            int x = Math.min(k - y, Math.min(w, e)); // find min to be changed after y
            max = Math.max(max, Math.abs(n - s) + Math.abs(w - e) + 2*(x + y));
        }
        return max;
    }
}
