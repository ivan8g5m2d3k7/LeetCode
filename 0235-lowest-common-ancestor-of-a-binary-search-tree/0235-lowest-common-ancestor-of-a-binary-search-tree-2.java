/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode result;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            traverse(root, p, q);
            return result;
        }

        public int traverse(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return 0;
            }

            int a = 0;
            if (node.equals(p) || node.equals(q)) {
                a += 1;
            }
            a += traverse(node.left, p, q) + traverse(node.right, p, q);

            if (a > 1 && result == null) {
                result = node;
            }
            return a;
        }
}