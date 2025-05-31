class Solution {
    public int heightChecker(int[] heights) {
            int[] unsorted = new int[heights.length];
            for (int i = 0; i < heights.length; i++) {
                unsorted[i] = heights[i];
            }
            
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int i = 0; i < heights.length - 1; i++) {
                    if (heights[i] > heights[i + 1]) {
                        swapped = true;
                        int temp = heights[i];
                        heights[i] = heights[i + 1];
                        heights[i + 1] = temp;
                    }
                }
            }
            
            int count = 0;
            for (int i = 0; i < heights.length; i++) {
                if (unsorted[i] != heights[i]) {
                    count++;
                }
            }
            
            return count;
        }
}