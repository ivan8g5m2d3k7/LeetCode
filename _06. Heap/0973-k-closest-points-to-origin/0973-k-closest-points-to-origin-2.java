class Solution {
    public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,
                    (a, b) -> {
                if (Math.sqrt(Math.pow(0 - points[a][0], 2) + Math.pow(0 - points[a][1], 2)) -
                        Math.sqrt(Math.pow(0 - points[b][0], 2) + Math.pow(0 - points[b][1], 2)) == 0) {
                    return 0;
                } else if (Math.sqrt(Math.pow(0 - points[a][0], 2) + Math.pow(0 - points[a][1], 2)) -
                        Math.sqrt(Math.pow(0 - points[b][0], 2) + Math.pow(0 - points[b][1], 2)) > 0) {
                    return 1;
                } else {
                    return -1;
                }
                    });

            for (int i = 0; i < points.length; i++) {
                minHeap.offer(i);
            }
            int[][] res = new int[k][2];
            for (int i = 0; i < k; i++) {
                int index = minHeap.poll();
                res[i][0] = points[index][0];
                res[i][1] = points[index][1];
            }

            return res;
        }
}