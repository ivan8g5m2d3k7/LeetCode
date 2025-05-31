class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i1 = 0;
            int i2 = 0;
            int[] nums1Copy = new int[m];
            System.arraycopy(nums1, 0, nums1Copy, 0, m);

            for (int i = 0; i < m + n; i++) {
                if (i1 >= m || (i2 < n && nums2[i2] < nums1Copy[i1])) {
                    nums1[i] = nums2[i2++];
                } else {
                    nums1[i] = nums1Copy[i1++];
                }
            }

        }
    }