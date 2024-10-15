class Solution {
    public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (set.contains(2 * num)) {
                    return true;
                }
                if (num % 2 == 0 && set.contains(num / 2)) {
                    return true;
                }

                set.add(num);
            }

            return false;
        }
}