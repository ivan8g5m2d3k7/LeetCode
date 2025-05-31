/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
     private Node first = null;
        private Node last = null;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }

            convert(root);
            first.left = last;
            last.right = first;
            return first;
        }

        public void convert(Node node) {
            if (node == null) {
                return;
            }

            convert(node.left);
            if (first == null) {
                first = node;
            } else {
                last.right = node;
                node.left = last;
            }
            last = node;
            convert(node.right);


        }
}