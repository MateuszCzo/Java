package mc.project.insert_delete_getRandom;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will
    }

    static class RandomizedSet {
        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new LinkedList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, list.size());
                list.add(val);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = map.get(val);
                int lastVal = list.get(list.size() - 1);
                list.set(index, lastVal);
                list.remove(list.size() - 1);
                map.put(lastVal, index);
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
