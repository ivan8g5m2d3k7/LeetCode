class Solution {
    public int[] sortArray(int[] nums) {
            if (nums.length < 2) {
                return nums;
            }

            int mid = nums.length / 2;
            int[] leftSublist = sortArray(Arrays.copyOfRange(nums, 0, mid));
            int[] rightSublist = sortArray(Arrays.copyOfRange(nums, mid, nums.length));

            return merge(leftSublist, rightSublist);
        }

        public int[] merge(int[] l1, int[] l2) {
            int i1 = 0, i2 = 0, i3 = 0;
            int[] res = new int[l1.length + l2.length];
            while (i1 < l1.length || i2 < l2.length) {
                if (i1 == l1.length) {
                    res[i3++] = l2[i2++];
                } else if (i2 == l2.length) {
                    res[i3++] = l1[i1++];
                } else if (l1[i1] < l2[i2]) {
                    res[i3++] = l1[i1++];
                } else {
                    res[i3++] = l2[i2++];
                }
            }

            return res;
        }
}