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
    public List<Integer> inorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            Set<TreeNode> visited = new LinkedHashSet<>();
            if (root == null) {
                return list;
            }
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                if (node.left != null && !visited.contains(node.left)) {
                    stack.push(node.left);
                    continue;
                }

                node = stack.pop();
                list.add(node.val);
                visited.add(node);

                if (node.right != null && !visited.contains(node.right)) {
                    stack.push(node.right);
                }
            }

            return list;
        }
}