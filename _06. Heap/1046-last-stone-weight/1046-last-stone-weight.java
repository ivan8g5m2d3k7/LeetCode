class Solution {
    public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, (a, b) -> Integer.compare(b, a));
            for (int a : stones) {
                maxHeap.offer(a);
            }

            while (maxHeap.size() > 1) {
                int heavier = maxHeap.poll();
                int lighter = maxHeap.poll();
                if (heavier > lighter) {
                    maxHeap.offer(heavier - lighter);
                }
            }
            
            if (maxHeap.isEmpty()) {
                return 0;
            } else {
                return maxHeap.poll();
            }
        }
}