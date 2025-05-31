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
    public boolean res = false;
        
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            dfs(root, targetSum, 0);
            return this.res;
        }
        
        public void dfs(TreeNode node, int target, int sum) {
            if (node == null) {
                return;
            }
            
            int curr = sum + node.val;
            dfs(node.left, target, curr);
            dfs(node.right, target, curr);
            
            if (node.left == null && node.right == null && curr == target && !this.res) {
               this.res = true;
            }
        }
}