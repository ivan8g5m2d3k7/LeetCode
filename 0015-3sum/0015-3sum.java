class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> set = new HashSet<>();
            int n = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                Set<Integer> seen = new HashSet<>();
                int left = i + 1;
                int right = n - 1;
                seen.add(nums[i]);

                while (left < right) {
                    int sumLR = nums[left] + nums[right];
                    int sum = nums[i] + nums[left] + nums[right];
                    if (seen.contains(-sumLR)) {
                        List<Integer> list = new ArrayList<>(List.of(-sumLR, nums[left], nums[right]));
                        Collections.sort(list);
                        set.add(list);
                        left++;
                    } else if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    }
                }
            }
            
            return new ArrayList<>(set);
        }
    }