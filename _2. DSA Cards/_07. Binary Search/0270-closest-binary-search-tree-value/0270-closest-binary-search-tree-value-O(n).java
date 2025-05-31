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
    TreeNode minNode = null;
        double minDist = Integer.MAX_VALUE;

        public int closestValue(TreeNode root, double target) {
            findMin(root, target);
            return minNode.val;
        }

        public void findMin(TreeNode node, double target) {
            if (node == null) {
                return;
            }

            int val = node.val;
            double dist = Math.abs(val - target);
            if (dist < minDist) {
                minNode = node;
                minDist = dist;
            } else if (dist == minDist && val < minNode.val) {
                minNode = node;
            }

            findMin(node.left, target);
            findMin(node.right, target);
        }
}