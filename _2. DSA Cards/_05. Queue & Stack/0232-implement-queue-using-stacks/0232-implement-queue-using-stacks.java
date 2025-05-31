class MyQueue {
    Deque<Integer> one = new ArrayDeque<>();
    Deque<Integer> two = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        one.push(x);
    }

    public int pop() {
        if (two.isEmpty()) {
            while (!one.isEmpty()) {
                two.push(one.pop());
            }
        }
        return two.pop();
    }

    public int peek() {
        if (two.isEmpty()) {
            while (!one.isEmpty()) {
                two.push(one.pop());
            }
        }
        return two.peek();
    }

    public boolean empty() {
        return two.isEmpty() && one.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */