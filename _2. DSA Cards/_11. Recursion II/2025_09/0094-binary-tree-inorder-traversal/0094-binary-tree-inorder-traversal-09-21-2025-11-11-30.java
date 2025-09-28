class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            Set<TreeNode> visited = new HashSet<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                if (stack.peek().left != null && !visited.contains(stack.peek().left)) {
                    stack.push(stack.peek().left);
                    continue;
                }

                TreeNode curr = stack.pop();
                list.add(curr.val);
                visited.add(curr);

                if (curr.right != null && !visited.contains(curr.right)) {
                    stack.push(curr.right);
                }
            }

            return list;
        }
    }