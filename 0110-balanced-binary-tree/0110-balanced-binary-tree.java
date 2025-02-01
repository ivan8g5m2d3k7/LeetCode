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
    private boolean result = true;

        public boolean isBalanced(TreeNode root) {
            check(root);
            return result;
        }

        public int check(TreeNode node) {
            if (node == null) {
                return -1;
            }

            int l = check(node.left);
            int r = check(node.right);

            if (Math.abs(l - r) > 1) {
                this.result = false;
            }

            return Math.max(l, r) + 1;
        }
}