class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numToFreq = new HashMap<>(nums.length);
            for (int num : nums) {
                numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[1]));
            for (int num : numToFreq.keySet()) {
                if (minHeap.size() < k) {
                    minHeap.offer(new int[]{num, numToFreq.get(num)});
                } else if (numToFreq.get(num) > minHeap.peek()[1]) {
                    minHeap.poll();
                    minHeap.offer(new int[]{num, numToFreq.get(num)});
                }
            }

            int[] array = new int[minHeap.size()];
            for (int i = array.length - 1; i >= 0; i--) {
                array[i] = minHeap.poll()[0];
            }

            return array;
        }
    }