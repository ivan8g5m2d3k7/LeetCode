class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numToCount = new HashMap<>();
            for (int num : nums) {
                numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> Integer.compare(numToCount.get(x), numToCount.get(y)));
            numToCount.entrySet().forEach(e -> {
                if (minHeap.size() < k) {
                    minHeap.offer(e.getKey());
                } else {
                    if (numToCount.get(minHeap.peek()) < e.getValue()) {
                        minHeap.poll();
                        minHeap.offer(e.getKey());
                    }
                }
            });

            return minHeap.stream().mapToInt(Integer::intValue).toArray();
        }
}