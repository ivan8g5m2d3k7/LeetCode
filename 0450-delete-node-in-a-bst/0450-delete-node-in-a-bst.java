/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode parent = root;
                    TreeNode successor = root.right;

                    while (successor.left != null) {
                        parent = successor;
                        successor = successor.left;
                    }

                    if (parent.equals(root)) {
                        successor.left = root.left;
                        root = successor;
                    } else {
                        successor.left = root.left;
                        parent.left = successor.right;
                        successor.right = root.right;
                        root = successor;
                    }
                }
            }

            return root;
        }
}