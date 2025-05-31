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

            Set<Integer> visited = new HashSet<>(n);
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(source);
            visited.add(source);
            int current = -1;

            while (!stack.isEmpty()) {
                current = stack.pop();
                if (current == destination) {
                    break;
                }

                for (int v : adj.get(current)) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        stack.push(v);
                    }
                }
            }

            return current == destination;
        }
    }