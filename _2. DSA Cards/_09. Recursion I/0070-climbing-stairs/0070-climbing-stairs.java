class Solution {
    public int climbStairs(int n) {
            int[] arr = new int[n + 1];
            return calculate(n, arr);
        }

        public int calculate(int x, int[] arr) {
            if (x < 4) {
                return x;
            }
            if (arr[x] != 0) {
                return arr[x];
            }

            int num = calculate(x -1, arr) + calculate(x - 2, arr);
            arr[x] = num;
            return num;
        }
}