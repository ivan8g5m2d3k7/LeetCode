class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            List<List<Integer>> list = new ArrayList<>(1 << n);
            
            for (int flags = 0; flags < (1 << n); flags++) {
                List<Integer> current = new ArrayList<>();
                int leadingZeros = Integer.numberOfLeadingZeros(flags); // 24
                int m = 32 - leadingZeros;
                int trailingZeros = Integer.numberOfTrailingZeros(flags); // 4
                
                for (int i = trailingZeros; i < m; i++) {
                    if (((flags >> i) & 1) != 0) {
                        current.add(nums[i]);
                    }
                }
                
                list.add(current);
            }
            
            return list;
        }
    }