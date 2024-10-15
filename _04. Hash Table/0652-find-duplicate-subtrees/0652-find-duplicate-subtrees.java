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
     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            Map<String, List<TreeNode>> map = new HashMap<>();
            traverse(root, map);
            List<TreeNode> result = new ArrayList<>();
            map.values().forEach(list -> {
                if (list.size() >= 2) {
                    result.add(list.getFirst());
                }
            });
            
            return result;
        }

        public StringBuilder traverse(TreeNode node, Map<String, List<TreeNode>> map) {
            if (node == null) {
                return new StringBuilder();
            }

//            String key = node.val + "," + traverse(node.left, map) + "," + traverse(node.right, map);
            StringBuilder sb = new StringBuilder();
            sb.append(node.val).append(",").append(traverse(node.left, map))
                    .append(",").append(traverse(node.right, map));

            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(node);

            return sb;
        }
}