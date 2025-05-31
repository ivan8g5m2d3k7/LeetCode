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
    private int res;

        public int maxDepth(TreeNode root) {
            traverse(root, 1);
            return res;
        }

        public void traverse(TreeNode node, int depth) {
            if (node == null) {
                return;
            }

            if (node.left == null && node.right == null) {
                this.res = Math.max(res, depth);
            }
            traverse(node.left, depth + 1);
            traverse(node.right, depth + 1);
        }
}