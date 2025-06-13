class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n < 2) {
                List<Integer> list = new ArrayList<>(2);
                for (int i = 0; i < n; i++) {
                    list.add(i);
                }
                return list;
            }

            List<Set<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adj.add(new HashSet<>());
            }
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (adj.get(i).size() == 1) {
                    queue.offer(i);
                }
            }

            int remainingNodes = n;
            while (remainingNodes > 2) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int u = queue.poll();
                    for (int v : adj.get(u)) {
                        adj.get(v).remove(u);
                        if (adj.get(v).size() == 1) {
                            queue.offer(v);
                        }
                    }
                }
                
                remainingNodes -= size;
            }

            return queue.stream().toList();
        }
    }