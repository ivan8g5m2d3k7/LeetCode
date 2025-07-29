class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>(nums1.length);
            for (int x : nums1) {
                set1.add(x);
            }
            List<Integer> list = new ArrayList<>();
            Set<Integer> added = new HashSet<>();
            for (int num : nums2) {
                if (set1.contains(num) && !added.contains(num)) {
                    list.add(num);
                    added.add(num);
                }
            }
            int[] array = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }

            return array;
        }
    }