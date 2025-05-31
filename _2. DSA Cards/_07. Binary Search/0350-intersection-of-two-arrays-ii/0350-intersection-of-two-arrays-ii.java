class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            List<Integer> list = new LinkedList<>();
            
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            
            int[] res = new int[list.size()];
            int k = 0;
            for (int a : list) {
                res[k++] = a;
            }
            
            return res;
        }
}