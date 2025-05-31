class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color) {
                return image;
            }
            int m = image.length;
            int n = image[0].length;
            int source = image[sr][sc];
            image[sr][sc] = color;

            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer((sr * n) + sc);
            while (!queue.isEmpty()) {
                int cell = queue.poll();
                int i = cell / n;
                int j = cell % n;

                if (i - 1 >= 0 && image[i - 1][j] == source) {
                    queue.offer((i - 1) * n + j);
                    image[i - 1][j] = color;
                }
                if (i + 1 < m && image[i + 1][j] == source) {
                    queue.offer((i + 1) * n + j);
                    image[i + 1][j] = color;
                }
                if (j - 1 >= 0 && image[i][j - 1] == source) {
                    queue.offer(i * n + j - 1);
                    image[i][j - 1] = color;
                }
                if (j + 1 < n && image[i][j + 1] == source) {
                    queue.offer(i * n + j + 1);
                    image[i][j + 1] = color;
                }
            }
            
            return image;
        }
}