class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            Set<Integer> set = new HashSet<>();
            boolean flag1 = false, flag2 = false;

            while (!flag1 && !flag2) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }

                if (i >= nums1.length) {
                    flag1 = true;
                    i = nums1.length - 1;
                }
                if (j >= nums2.length) {
                    flag2 = true;
                    j = nums2.length - 1;
                }
            }

            int[] res = new int[set.size()];
            int k = 0;
            for (int a : set) {
                res[k++] = a;
            }

            return res;
        }
}