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
class BSTIterator {

    private List<Integer> list;
        private int index;

        public BSTIterator(TreeNode root) {
            this.list = new ArrayList<>();
            this.index = -1;
            traverse(root);
        }
        
        public void traverse(TreeNode node) {
            if (node == null) {
                return;
            }
            
            traverse(node.left);
            this.list.add(node.val);
            traverse(node.right);
        }

        public int next() {
            return this.list.get(++this.index);
        }

        public boolean hasNext() {
            return this.index < this.list.size() - 1;
        }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */