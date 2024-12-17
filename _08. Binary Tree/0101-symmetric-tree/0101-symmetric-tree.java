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
    public boolean isSymmetric(TreeNode root) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            traverseLeft(root.left, left);
            traverseRight(root.right, right);

            return left.toString().equals(right.toString());
        }

        public void traverseLeft(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null").append(",");
                return;
            }

            sb.append(node.val).append(',');
            traverseLeft(node.left, sb);
            traverseLeft(node.right, sb);
        }

        public void traverseRight(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null").append(",");
                return;
            }

            sb.append(node.val).append(',');
            traverseRight(node.right, sb);
            traverseRight(node.left, sb);
        }
}