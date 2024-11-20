class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;

        // Binary search to find the first element greater than or equal to x
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Adjust pointers for two-pointer traversal
        left = left - 1; // Left points to the largest smaller element
        right = left + 1; // Right points to the smallest larger element

        // Collect k closest elements
        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            if (left < 0) { // If left pointer is out of bounds
                result.add(arr[right++]);
            } else if (right >= arr.length) { // If right pointer is out of bounds
                result.add(arr[left--]);
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }
            k--;
        }

        // Sort result before returning
        Collections.sort(result);
        return result;
    }
}