class Solution {
    public int[] twoSum(int[] numbers, int target) {
            // [1,1,1,1,3,5]
            for (int i = 0; i + 1 < numbers.length; i++) {
                int a = numbers[i];
                int b = target - a;
                int left = i + 1;
                int right = numbers.length - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (numbers[mid] == b) {
                        return new int[] {i + 1, mid + 1};
                    } else if (numbers[mid] > b) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            
            return new int[] {-1, -1};
        }
}