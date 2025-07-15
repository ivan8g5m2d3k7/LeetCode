class Solution {
        public int kthSmallest(TreeNode root, int k) {
            int counter = 0;
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.offer(root);
            Set<TreeNode> visited = new HashSet<>();
            visited.add(root);

            while (!stack.isEmpty()) {
                TreeNode current = stack.peek();
                if (current.left != null && !visited.contains(current.left)) {
                    stack.push(current.left);
                    visited.add(current.left);
                    continue;
                }
                
                current = stack.pop();
                if (++counter == k) {
                    return current.val;
                }
                
                if (current.right != null && !visited.contains(current.right)) {
                    stack.push(current.right);
                }
            }
            
            return -1;
        }
    }