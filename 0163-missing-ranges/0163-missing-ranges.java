class Solution {
        public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length == 0) {
                return result;
            }
            if (lower < nums[0]) {
                result.add(List.of(lower, nums[0] - 1));
            }

            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] + 1 < nums[i]) {
                    result.add(List.of(nums[i -1] + 1, nums[i] - 1));
                }
            }

            if (nums[nums.length - 1] < upper) {
                result.add(List.of(nums[nums.length - 1] + 1, upper));
            }

            return result;
        }
    }