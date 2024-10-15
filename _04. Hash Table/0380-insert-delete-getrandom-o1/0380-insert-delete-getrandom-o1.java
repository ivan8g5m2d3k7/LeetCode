 class RandomizedSet {
            private List<Integer> list;
            private Map<Integer, Integer> intToIndex;

            public RandomizedSet() {
                this.list = new ArrayList<>();
                this.intToIndex = new HashMap<>();
            }

            public boolean insert(int val) {
                if (intToIndex.containsKey(val)) {
                    return false;
                }

                intToIndex.put(val, list.size());
                list.add(val);
                return true;
            }

            public boolean remove(int val) {
                if (!intToIndex.containsKey(val)) {
                    return false;
                }

                int index = intToIndex.remove(val);
                list.set(index, list.getLast());
                list.removeLast();
                if (!list.isEmpty() && index < list.size()) {
                    intToIndex.put(list.get(index), index);
                }

                return true;
            }

            public int getRandom() {
                int index = new Random().nextInt(list.size());
                return list.get(index);
            }
        }
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */