/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
     public Node connect(Node root) {
            Deque<Node> stack = new ArrayDeque<>();
            if (root == null) {
                return root;
            }
            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Deque<Node> newQueue = new LinkedList<>();
                while (!queue.isEmpty()) {
                    Node curr = queue.poll();
                    if (!queue.isEmpty()) {
                        curr.next = queue.peek();
                    }
                    if (curr.left != null) {
                        newQueue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        newQueue.offer(curr.right);
                    }
                }
                
                queue = newQueue;
            }

            return root;
        }
}