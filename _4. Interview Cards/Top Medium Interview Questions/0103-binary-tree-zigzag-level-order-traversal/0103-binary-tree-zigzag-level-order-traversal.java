class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) {
                return list;
            }

            boolean leftToRight = true;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    level.add(curr.val);
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }

                if (leftToRight) {
                    list.add(level);
                    leftToRight = false;
                } else {
                    Collections.reverse(level);
                    list.add(level);
                    leftToRight = true;
                }
            }
            
            return list;
        }
    }