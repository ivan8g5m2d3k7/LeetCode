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

        private int[] max = new int[1];

        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            dfs(root, 1);
            return this.max[0];
        }

        public void dfs(Node node, int depth) {
            if (node == null) {
                return;
            }

            for (Node child : node.children) {
                dfs(child, depth + 1);
            }
            
            this.max[0] = Math.max(this.max[0], depth);
        }
    }