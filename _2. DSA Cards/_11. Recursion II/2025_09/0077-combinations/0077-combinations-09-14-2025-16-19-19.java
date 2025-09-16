class Solution {
        List<List<Integer>> combinations = new ArrayList<>();
        int start = 0;

        public List<List<Integer>> combine(int n, int k) {

            // [1, 2, 3, 4, 5, 6]
            generate(1, n, k, new ArrayList<>(k));
            return this.combinations;
        }

        public void generate(int start, int n, int k, List<Integer> list) {
            if (list.size() == k) {
                combinations.add(new ArrayList<>(list));
                return;
            }
            if (start > n) {
                return;
            }

            for (int i = start; i <= n; i++) {
                list.add(i);
                generate(i + 1, n, k, list);
                list.removeLast();
            }
        }
    }