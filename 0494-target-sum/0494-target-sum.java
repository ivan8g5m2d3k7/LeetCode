class Solution {
    public int findTargetSumWays(int[] nums, int target) {
            Map<Integer, Integer> sumToCount = new HashMap<>();
            sumToCount.put(nums[0], 1);
            sumToCount.put(-nums[0], sumToCount.getOrDefault(-nums[0], 0)+ 1);

            for (int i = 1; i < nums.length; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : sumToCount.entrySet()) {
                    int sum1 = entry.getKey() + nums[i];
                    int sum2 = entry.getKey() - nums[i];

                    map.put(sum1, entry.getValue() + map.getOrDefault(sum1, 0));
                    map.put(sum2, entry.getValue() + map.getOrDefault(sum2, 0));
                }
                sumToCount = map;
            }

            return sumToCount.getOrDefault(target, 0);
        }
}