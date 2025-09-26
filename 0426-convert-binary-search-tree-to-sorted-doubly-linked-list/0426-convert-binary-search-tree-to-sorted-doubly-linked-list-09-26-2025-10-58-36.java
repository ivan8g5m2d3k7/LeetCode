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
        Node head = null;
        Node tail = null;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            convert(root);
            this.head.left = this.tail;
            this.tail.right = this.head;
            return this.head;
        }

        public void convert(Node node) {
            if (node == null) {
                return;
            }

            convert(node.left);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.right = node;
                node.left = this.tail;

            }
            this.tail = node;

            convert(node.right);
        }
    }