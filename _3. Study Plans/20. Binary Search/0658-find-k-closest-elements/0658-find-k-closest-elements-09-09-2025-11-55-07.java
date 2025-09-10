class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            right = left;
            left--;

            while (right - left - 1 < k) {
                if (left < 0) {
                    right++;
                } else if (right >= arr.length) {
                    left--;
                } else {
                    int a = Math.abs(arr[left] - x);
                    int b = Math.abs(arr[right] - x);
                    if (a <= b) {
                        left--;
                    } else {
                        right++;
                    }
                }
            }
            
            List<Integer> list = new ArrayList<>(k);
            for (int i = left + 1; i < right; i++) {
                list.add(arr[i]);
            }
            
            return list;
        }
    }