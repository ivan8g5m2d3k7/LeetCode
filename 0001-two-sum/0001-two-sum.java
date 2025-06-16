class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> valToIndexes = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                valToIndexes.putIfAbsent(nums[i], new ArrayList<>());
                valToIndexes.get(nums[i]).add(i);
            }
            
            for (int i  = 0; i < nums.length; i++) {
                int val = nums[i];
                int x = target - val;
                if (x == val) {
                    List<Integer> list = valToIndexes.get(x);
                    if (list.size() > 1) {
                        return new int[] { list.get(0), list.get(1) };
                    }
                } else {
                    if (valToIndexes.containsKey(x)) {
                        return new int[] { i, valToIndexes.get(x).get(0) };
                    }
                }
            }
            
            return new int[] { -1, -1 };
        }
    }