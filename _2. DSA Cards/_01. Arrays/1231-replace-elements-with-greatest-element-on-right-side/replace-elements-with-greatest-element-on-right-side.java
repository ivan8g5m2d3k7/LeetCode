class Solution {
     public int[] replaceElements(int[] arr) {
            int max = 0;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                }
                
                int temp = arr[i];
                arr[i] = max;
                
                if (temp > max) {
                    max = temp;
                }
            }

            arr[arr.length - 1] = -1;
            return  arr;
        }
}