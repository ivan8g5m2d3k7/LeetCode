class Solution {
    List<List<Integer>> list;
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> current = new ArrayList<>(nums.length);
            int fact = 1;
            for (int i = 2; i <= nums.length; i++) {
                fact = fact * i;
            }
            list = new ArrayList<>(fact);
            used = new boolean[nums.length];

            generate(nums, used, current, 0);
            return list;
        }

        public void generate(int[] nums, boolean[] used, List<Integer> current, int i) {
            if (i == nums.length) {
                list.add(current);
                return;
            }

            for (int j = 0; j < used.length; j++) {
                if (!used[j]) {
                    current.add(nums[j]);
                    used[j] = true;
                    generate(nums, used, new ArrayList<>(current), i + 1);

                    current.removeLast();
                    used[j] = false;
                }
            }
        }
}