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
    private int idx = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> elementToIndex = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                elementToIndex.put(inorder[i], i);
            }
            
            return build(preorder, inorder, elementToIndex, 0, preorder.length - 1);
        }

        public TreeNode build(int[] preorder, int[] inorder, Map<Integer, Integer> elementToIndex, int inLeft, int inRight) {
            if (inLeft > inRight || idx >= preorder.length) {
                return null;
            }
            
            TreeNode node = new TreeNode(preorder[idx++]);
            int index = elementToIndex.get(node.val);
            node.left = build(preorder, inorder, elementToIndex, inLeft, index - 1);
            node.right = build(preorder, inorder, elementToIndex, index + 1, inRight);
            
            return node;
        }
}