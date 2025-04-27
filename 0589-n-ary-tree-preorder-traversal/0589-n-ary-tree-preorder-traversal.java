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
        public List<Integer> preorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);
            Node current = null;

            while (!stack.isEmpty()) {
                current = stack.pop();
                list.add(current.val);
                for (int i = current.children.size() - 1; i >= 0; i--) {
                    stack.push(current.children.get(i));
                }
            }
            
            return list;
        }
    }