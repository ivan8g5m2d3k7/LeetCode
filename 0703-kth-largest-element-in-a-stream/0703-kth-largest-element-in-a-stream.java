class KthLargest {
            private int[] scores;
            private int k;
            private PriorityQueue<Integer> minHeap;

            public KthLargest(int k, int[] nums) {
                this.scores = nums;
                this.k = k;
                this.minHeap = new PriorityQueue<>(k);
                for (int num : nums) {
                    if (this.minHeap.size() < k) {
                        this.minHeap.offer(num);
                    } else {
                        if (num > this.minHeap.peek()) {
                            this.minHeap.poll();
                            this.minHeap.offer(num);
                        }
                    }
                }
            }

            public int add(int val) {
                if (this.minHeap.isEmpty() || this.minHeap.size() < k) {
                    this.minHeap.offer(val);
                } else if (val > this.minHeap.peek()) {
                    this.minHeap.poll();
                    this.minHeap.offer(val);
                }

                return this.minHeap.peek();
            }
        }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */