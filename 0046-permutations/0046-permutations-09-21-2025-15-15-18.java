class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            generate(nums, list, new ArrayList<>(), 0);
            return list;
        }

        public void generate(int[] nums, List<List<Integer>> list,
                             List<Integer> current, int used) {
            if (current.size() == nums.length) {
                list.add(new ArrayList<>(current));
                return;
            }

            int available = (~used) & ( (1 << nums.length) - 1);
            for (int m = available; m != 0; m &= m - 1) {
                int i = Integer.numberOfTrailingZeros(m);
                int bit = m & -m;

                used |= bit;
                current.add(nums[i]);
                generate(nums, list, current, used);
                current.removeLast();
                used &= ~bit;
            }
        }
    }