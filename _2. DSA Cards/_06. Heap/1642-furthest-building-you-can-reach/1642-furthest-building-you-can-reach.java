class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(heights.length, (a, b) -> b - a);
            int i = 0;
            for (i = 0; i <= heights.length - 2; i++) {
                int curr = heights[i + 1] - heights[i];
                if (curr > 0) {
                    maxHeap.offer(curr);
                    bricks -= curr;
                    if (bricks < 0) {
                        if (ladders > 0) {
                            ladders--;
                            if (!maxHeap.isEmpty()) {
                                bricks += maxHeap.poll();
                            }
                        } else {
                            break;
                        }
                    }
                }
            }

            return i;
        }
}