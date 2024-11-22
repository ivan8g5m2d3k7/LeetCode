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
     public int closestValue(TreeNode root, double target) {
            TreeNode minNode = root;
            double minDist = Integer.MAX_VALUE;
            while (root != null) {
                double dist = Math.abs(root.val - target);
                if (dist < minDist) {
                    minNode = root;
                    minDist = dist;
                } else if (dist == minDist && root.val < minNode.val) {
                    minNode = root;
                }
                
                if (target == root.val) {
                    break;
                } else if (target < root.val) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            
            return minNode.val;
        }
}