class Solution {
     public List<Integer> grayCode(int n) {
            boolean[] used = new boolean[1 << n];
            List<Integer> list = new ArrayList<>(1 << n);
            list.add(0);
            used[0] = true;
            if (fill(used, list, n)) {
                return list;
            } else {
                return List.of(1,1,1,1);
            }
        }

        public boolean fill(boolean[] used, List<Integer> list, int n) {
            if (list.size() == used.length) {
                return (Integer.bitCount(list.getFirst() ^ list.getLast()) == 1);
            }

            for (int i = 0; i < n; i++) {
                int a = list.getLast() ^ (1 << i);
                if (!used[a]) {
                    list.add(a);
                    used[a] = true;

                    if (fill(used, list, n)) {
                        return true;
                    }

                    list.removeLast();
                    used[a] = false;
                }
            }

            return false;
        }
}