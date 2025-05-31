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
    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            
            while (!queue.isEmpty()) {
                Deque<TreeNode> next = new ArrayDeque<>();
                List<Integer> level = new ArrayList<>();
                int n = queue.size();
                
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        next.offer(node.left);
                    }
                    if (node.right != null) {
                        next.offer(node.right);
                    }
                }
                
                res.add(level);
                queue = next;
            }
            
            return res;
        }
}