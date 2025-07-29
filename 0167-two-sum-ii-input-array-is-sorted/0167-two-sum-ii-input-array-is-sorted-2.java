class Solution {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                if (i > 0 && numbers[i] == numbers[i - 1]) {
                    continue;
                }

                int val = target - numbers[i];
                int left = 0;
                int right = numbers.length - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (numbers[mid] == val) {
                        if (mid < i) {
                            return new int[] {mid + 1, i + 1};
                        } else if (mid > i) {
                            return new int[] {i + 1, mid + 1};
                        } else {
                            if (left != mid && numbers[left] == val) {
                                return left < i ? new int[] {left + 1, i + 1} : new int[] {i + 1, left + 1};
                            } else {
                                left++;
                            }
                        }
                    } else if (numbers[mid] < val) {
                        left = mid + 1;
                    } else if (numbers[mid] > val) {
                        right = mid - 1;
                    }
                }
            }
            
            return new int[] {-1, -1};
        }
    }