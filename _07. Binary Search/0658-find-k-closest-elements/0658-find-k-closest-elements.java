class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int curr = arr[mid];
                if (curr >= x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int[] res = new int[k];
            int i = 0;
            right = left;
            left--;

            while (k-- > 0) {
                if (left < 0) {
                    res[i++] = arr[right++];
                } else if (right > arr.length - 1) {
                    res[i++] = arr[left--];
                } else if (Math.abs(arr[left] - x) == Math.abs(arr[right] - x)) {
                    res[i++] = arr[left--];
                } else if (Math.abs(arr[left] - x) < Math.abs(arr[right] - x)) {
                    res[i++] = arr[left--];
                } else if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                    res[i++] = arr[right++];
                }
            }

            return Arrays.stream(res).boxed().sorted().collect(Collectors.toList());
        }
}