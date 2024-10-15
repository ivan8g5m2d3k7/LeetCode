class Solution {
      public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer[]> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                if (map.containsKey(nums1[i])) {
                    map.get(nums1[i])[0] += 1;
                } else {
                    map.put(nums1[i], new Integer[]{1, 0});
                }
            }

            int count = 0;
            for (int i = 0; i < nums2.length; i++) {
                if (map.containsKey(nums2[i])) {
                    map.get(nums2[i])[1] += 1;
                    if (map.get(nums2[i])[1] <= map.get(nums2[i])[0]) {
                        count++;
                    }
                }
            }

            int[] result = new int[count];
            int j = 0;
            for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
                if (entry.getValue()[0] > 0 && entry.getValue()[1] > 0) {
                    int n = Math.min(entry.getValue()[0], entry.getValue()[1]);
                    for (int i = 0; i < n; i++) {
                        result[j++] = entry.getKey();
                    }
                }
            }

            return result;
        }
}