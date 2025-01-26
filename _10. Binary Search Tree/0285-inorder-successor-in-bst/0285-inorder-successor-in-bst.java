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
    int index = -1;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            List<TreeNode> list = new ArrayList<>();
            traverse(root, list, p.val);
            if (index != -1 && index < list.size() - 1) {
                return list.get(index + 1);
            } else {
                return null;
            }
        }

        public void traverse(TreeNode node, List<TreeNode> list, int val) {
            if (node == null) {
                return;
            }

            traverse(node.left, list, val);
            list.add(node);
            if (node.val == val) {
                this.index = list.size() - 1;
            }
            traverse(node.right, list, val);
        }
}