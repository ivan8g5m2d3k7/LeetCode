class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
            Arrays.sort(nums);
            generateSets(nums, subsets, new ArrayDeque<>(), 0);

            return subsets;
        }

        private void generateSets(int[] nums, List<List<Integer>> subsets,
                                  Deque<Integer> current, int start) {
            if (start == nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }

                current.push(nums[i]);
                subsets.add(new ArrayList<>(current));
                generateSets(nums, subsets, current, i + 1);
                current.pop();
            }
        }
    }