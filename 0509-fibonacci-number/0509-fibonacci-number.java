class Solution {
    public int fib(int n) {
            int[] arr = new int[n + 1];
            return calculate(n, arr);
        }

        public int calculate(int n, int[] arr) {
            if (n < 2) {
                return n;
            }
            if (arr[n] != 0) {
                return arr[n];
            }

            int num = calculate(n - 1, arr) + calculate(n - 2, arr);
            arr[n] = num;
            return num;
        }
}