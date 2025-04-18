class Solution {
    public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            generate(res, new ArrayList<>(), 1, n, k);
            return res;
        }

        public void generate(List<List<Integer>> res, List<Integer> list, int start, int n, int k) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = start; i <= n; i++) {
                list.add(i);
                generate(res, list, i + 1, n, k);
                list.removeLast();
            }
        }
}