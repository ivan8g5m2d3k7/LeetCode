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
    private int[] inorder;
        private int[] postorder;
        private int idx = -1;
        private Map<Integer, Integer> elementToIndex;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;
            this.idx = postorder.length - 1;
            Map<Integer, Integer> elementToIndex = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                elementToIndex.put(inorder[i], i);
            }
            this.elementToIndex = elementToIndex;

            return build(0, this.inorder.length - 1);
        }

        public TreeNode build(int inLeft, int inRight) {
            if (inLeft > inRight || this.idx < 0) {
                return null;
            }

            TreeNode node = new TreeNode(this.postorder[idx--]);
            int index = this.elementToIndex.get(node.val);
            node.right = build(index + 1, inRight);
            node.left = build(inLeft, index -1);

            return node;
        }
}