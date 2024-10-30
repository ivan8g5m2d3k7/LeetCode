class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(mat.length, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            });
            for (int i = 0; i < mat.length; i++) {
                int c = 0;
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1) {
                        c++;
                    }
                }
                minHeap.offer(new int[] {c, i});
            }

//            return minHeap.stream().limit(k).map(a -> a[1]).mapToInt(Integer::intValue).toArray();
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = minHeap.poll()[1];
            }
            return res;
        }
}