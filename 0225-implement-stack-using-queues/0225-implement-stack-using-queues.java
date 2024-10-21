class MyStack {
    private int size;
    private Deque<Integer> queue = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        this.queue.offer(x);
        this.size++;
    }

    public int pop() {
        int res = -1;
        int i = 0;
        while (i < this.size) {
            int curr = queue.poll();
            i++;
            if (i == this.size) {
                this.size--;
                res = curr;
                break;
            }

            queue.offer(curr);
        }

        return res;
    }

    public int top() {
        int res = -1;
        int i = 0;
        while (i < this.size) {
            int curr = queue.poll();
            i++;
            if (i == this.size) {
                res = curr;
            }
            queue.offer(curr);
        }

        return res;
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */