class Solution {
    public boolean validMountainArray(int[] arr) {
            if (arr.length < 3 || arr[0] >= arr[1]) {
                return false;
            }

            boolean change = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] < arr[i] && !change) {
                    continue;
                } else if (arr[i - 1] == arr[i]) {
                    return false;
                } else if (arr[i - 1] > arr[i] && !change) {
                    change = true;
                } else if (arr[i - 1] > arr[i] && change) {
                    continue;
                } else {
                    return false;
                }
            }

            return change;
        }
}