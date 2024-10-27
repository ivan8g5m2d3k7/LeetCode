class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numToCount = new HashMap<>();
            for (int num : nums) {
                numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
            }
            
            return numToCount.entrySet().stream().sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed())
                    .limit(k).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
        }
}