class Node {
    public int val;
    public Node prev;

    public Node(int val, Node prev) {
        this.val = val;
        this.prev = prev;
    }
}

class MinStack {
    private Node top;
    private Map<Integer, Integer> valToCount;

    public MinStack() {
        this.top = null;
        this.valToCount = new TreeMap<>();
    }

    public void push(int val) {
        this.top = new Node(val, top);
        this.valToCount.put(val, this.valToCount.getOrDefault(val, 0) + 1);
    }

    public void pop() {
        Node temp = this.top.prev;
        this.top.prev = null;
        this.valToCount.put(this.top.val, this.valToCount.get(this.top.val) - 1);
        if (this.valToCount.get(this.top.val) <= 0) {
            this.valToCount.remove(this.top.val);
        }
        this.top = temp;
    }

    public int top() {
        return this.top.val;
    }

    public int getMin() {
        return this.valToCount.keySet().iterator().next();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */