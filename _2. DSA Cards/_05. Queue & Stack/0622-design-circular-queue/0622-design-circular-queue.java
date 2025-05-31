class MyCircularQueue {
            private int[] data;
            private int head;
            private int tail;
            private int size;

            public MyCircularQueue(int k) {
                this.data = new int[k];
                Arrays.fill(data, -1);
                this.head = -1;
                this.tail = -1;
                this.size = 0;
            }

            public boolean enQueue(int value) {
                if (this.isFull()) {
                    return false;
                }

                if (this.tail == this.data.length - 1 && this.head >= 1 && !this.isFull()) {
                    this.tail = 0;
                    this.data[this.tail] = value;
                } else if (this.tail > this.head && this.tail <= this.data.length - 2
                || this.tail < this.head && !this.isFull()) {
                    this.data[++this.tail] = value;
                } else if (this.isEmpty()) {
                    this.head = 0;
                    this.tail = 0;
                    this.data[this.tail] = value;
                } else {
                    this.data[++this.tail] = value;
                }

                this.size++;
                return true;
            }

            public boolean deQueue() {
                if (this.isEmpty()) {
                    return false;
                }

                if (this.head == this.data.length - 1 && this.head == this.tail) {
                    this.data[this.head] = -1;
                    this.head = -1;
                    this.tail = -1;
                } else if (this.head == this.data.length - 1 && this.head > this.tail) {
                    this.data[this.head] = -1;
                    this.head = 0;
                } else {
                    this.data[this.head++] = -1;
                }

                this.size--;
                return true;
            }

            public int Front() {
                if (this.isEmpty()) {
                    return -1;
                }
                return this.data[this.head];
            }

            public int Rear() {
                if (this.isEmpty()) {
                    return -1;
                }
                return this.data[this.tail];
            }

            public boolean isEmpty() {
                return this.size <= 0;
            }

            public boolean isFull() {
                return this.size == this.data.length;
            }
        }


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */