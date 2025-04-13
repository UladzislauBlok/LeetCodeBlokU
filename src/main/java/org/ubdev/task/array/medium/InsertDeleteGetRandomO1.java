package org.ubdev.task.array.medium;

import java.util.*;

public class InsertDeleteGetRandomO1 {

    public static class RandomizedSet {

        private final List<Integer> list;
        private final Map<Integer, Integer> map;
        private final Random random;

        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
            this.random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int lstListVal = list.getLast();
            list.set(index, lstListVal);
            map.put(lstListVal, index);
            map.remove(val);
            list.removeLast();
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}
