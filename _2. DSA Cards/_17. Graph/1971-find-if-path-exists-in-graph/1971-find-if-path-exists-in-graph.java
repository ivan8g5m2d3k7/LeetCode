class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            List<List<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            
            Set<Integer> visited = new HashSet<>();
            Deque<Integer> queue = new ArrayDeque<>();
            visited.add(source);
            queue.offer(source);
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (current == destination) {
                    return true;
                }
                
                for (int v : adj.get(current)) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        queue.offer(v);
                    }
                }
            }
            
            return false;
        }
    }