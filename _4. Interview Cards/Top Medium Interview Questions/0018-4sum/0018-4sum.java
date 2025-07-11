class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();

            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j < n - 2; j++) {
                    int left = j + 1;
                    int right = n - 1;
                    while (left < right) {
                        long sum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];

                        if (sum == (long) target) {
                            set.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            right--;
                        } else if (sum < (long) target) {
                            left++;
                        } else {
                            right--;
                        }
                        
                        while (left > j + 1 && right < n - 1 && left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left > j + 1 && right < n - 1 && left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }

            return set.stream().toList();
        }
    }