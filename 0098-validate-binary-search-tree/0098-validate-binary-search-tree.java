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
    public boolean isValidBST(TreeNode root) {
            return check(root.left, Long.MIN_VALUE, root.val) && check(root.right, root.val, Long.MAX_VALUE);
        }

        public boolean check(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }

            boolean left = check(node.left, min, node.val);
            boolean right = check(node.right, node.val, max);

            return left && right;
        }
}