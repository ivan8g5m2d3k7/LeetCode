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
    public int count = 0;

        public int countUnivalSubtrees(TreeNode root) {
            count = 0;
            traverse(root);
            return count;
        }

        public boolean traverse(TreeNode node) {
           if (node == null) {
               return true;
           }

           boolean left = traverse(node.left);
           boolean right = traverse(node.right);
           if (!left || !right ||
                   node.left != null && node.left.val != node.val ||
                   node.right != null && node.right.val != node.val) {
               return false;
           }

           this.count++;
           return true;
        }
}