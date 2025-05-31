/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            if (node.neighbors == null || node.neighbors.isEmpty()) {
                return new Node(node.val);
            }

            Map<Node, Node> oldToClone = new HashMap<>();
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(node);
            Node res = null;

            while (!stack.isEmpty()) {
                Node old = stack.pop();
                oldToClone.putIfAbsent(old, new Node(old.val));
                Node clone = oldToClone.get(old);
                if (res == null) {
                    res = clone;
                }

                for (Node n : old.neighbors) {
                    if (!oldToClone.containsKey(n)) {
                        oldToClone.put(n, new Node(n.val));
                        stack.push(n);
                    }
                    clone.neighbors.add(oldToClone.get(n));
                }
            }

            return res;
        }
}