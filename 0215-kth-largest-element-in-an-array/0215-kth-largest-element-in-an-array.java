class Solution {
    public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
            for (int curr : nums) {
                if (minHeap.size() < (k)) {
                    minHeap.offer(curr);
                } else if (!minHeap.isEmpty() && curr > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(curr);
                }
            }

            return minHeap.peek();
        }
}