class Solution {
     public int connectSticks(int[] sticks) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(sticks.length);
            Arrays.stream(sticks).forEach(minHeap::offer);
            int res = 0;
            while (minHeap.size() >= 2) {
                int a = minHeap.poll();
                int b = minHeap.poll();
                res += a + b;
                minHeap.offer(a + b);
            }
            return res;
        }
}