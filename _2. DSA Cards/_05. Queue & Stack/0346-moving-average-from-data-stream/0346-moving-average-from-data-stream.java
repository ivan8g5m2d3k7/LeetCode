class MovingAverage {
            private Deque<Integer> queue;
            int sum;
            int size;

            public MovingAverage(int size) {
                this.queue = new ArrayDeque<>(size);
                this.sum = 0;
                this.size = size;
            }

            public double next(int val) {
                if (this.queue.size() == this.size) {
                    this.sum -= this.queue.poll();
                }
                this.queue.offer(val);
                this.sum += val;
                
                return (double) this.sum /this.queue.size();
            }
        }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */