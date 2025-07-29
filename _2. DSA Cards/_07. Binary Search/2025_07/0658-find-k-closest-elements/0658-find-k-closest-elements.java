class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length - 1;

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
            List<Integer> list = new ArrayList<>(k);

            while (list.size() < k) {
                if (left < 0) {
                    list.add(arr[right++]);
                    continue;
                }
                if (right >= arr.length) {
                    list.add(arr[left--]);
                    continue;
                }

                int leftNum = arr[left];
                int rightNum = arr[right];

                if (Math.abs(leftNum - x) < Math.abs(rightNum - x)) {
                    list.add(leftNum);
                    left--;
                } else if (Math.abs(leftNum - x) > Math.abs(rightNum - x)) {
                    list.add(rightNum);
                    right++;
                } else {
                    if (leftNum < rightNum) {
                        list.add(leftNum);
                        left--;
                    } else {
                        list.add(rightNum);
                        right++;
                    }
                }
            }

            Collections.sort(list);
            return list;
        }
    }