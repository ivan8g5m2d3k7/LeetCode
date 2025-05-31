class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int result = 0;
            Map<Integer, Integer> sumToCount = new HashMap<>();
            for (int i : nums1) {
                for (int j : nums2) {
                    sumToCount.put(i + j, sumToCount.getOrDefault(i + j, 0) + 1);
                }
            }
            
            for (int k : nums3) {
                for (int l : nums4) {
                    result += sumToCount.getOrDefault(-(k + l), 0);
                }
            }
            
            return result;
        }
}