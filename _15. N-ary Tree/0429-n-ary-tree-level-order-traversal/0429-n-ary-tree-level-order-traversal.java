/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> list = new ArrayList<>(count);
                for (int i = 0; i < count; i++) {
                    Node current = queue.poll();
                    list.add(current.val);
                    for (Node child : current.children) {
                        queue.offer(child);
                    }
                }
                
                result.add(list);
            }
            
            return result;
        }
    }