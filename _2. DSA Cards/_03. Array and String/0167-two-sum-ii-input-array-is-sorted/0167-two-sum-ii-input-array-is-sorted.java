class Solution {
    public int[] twoSum(int[] numbers, int target) {
            // Input: numbers = [2,7,11,15], target = 9
            int left = 0;
            int right = numbers.length - 1;
            
            while (left < right) {
                int one = numbers[left];
                int two = numbers[right];
                int sum = one + two;
                
                if (sum == target) {
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            int[] result = new int[2];
            result[0] = left + 1;
            result[1] = right + 1;
            return result;
        }
}