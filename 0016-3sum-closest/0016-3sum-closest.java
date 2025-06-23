class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int minDist = Integer.MAX_VALUE;
            int closestSum = 0;
            int n = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                int left = i + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    int dist = Math.abs(target - sum);
                    if (dist < minDist) {
                        minDist = dist;
                        closestSum = sum;
                    }

                    if (sum == target) {
                        return target;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return closestSum;
        }
    }