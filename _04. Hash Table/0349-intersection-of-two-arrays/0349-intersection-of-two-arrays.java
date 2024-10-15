class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
            Map<Integer, Boolean> map = new HashMap<>();
            for (int x : nums1) {
                if (!map.containsKey(x)) {
                    map.put(x, false);
                }
            }

            for (int x : nums2) {
                if (map.containsKey(x)) {
                    map.put(x, true);
                }
            }

            return map.entrySet().stream().filter(Map.Entry::getValue)
                    .map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
        }
}