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
            traverse(root, p.val, q.val);
            return result;
        }

        public int traverse(TreeNode node, int p, int q) {
            if (node == null) {
                return 0;
            }
            
            int a = 0;
            if (node.val == p || node.val == q) {
                a += 1;
            }
            
            a += traverse(node.left, p, q) + traverse(node.right, p, q);
            if (a > 1 && this.result == null) {
                this.result = node;
            }
            
            return a;
        }
}