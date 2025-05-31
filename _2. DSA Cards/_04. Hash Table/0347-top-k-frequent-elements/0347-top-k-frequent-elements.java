class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numToCount = new HashMap<>();
            for (int a : nums) {
                numToCount.put(a, numToCount.getOrDefault(a, 0) + 1);
            }

            return numToCount.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(k)
                    .mapToInt(Map.Entry::getKey).toArray();
        }
}