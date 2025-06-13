class Solution {
        public int minimumSemesters(int n, int[][] relations) {
            List<List<Integer>> adj = new ArrayList<>(n + 1);
            for (int i = 0; i < n + 1; i++) {
                adj.add(new ArrayList<>());
            }
            int[] inDegree = new int[n + 1];
            for (int[] edge : relations) {
                int prev = edge[0];
                int next = edge[1];
                inDegree[next]++;
                adj.get(prev).add(next);
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int count = 0;
            int semesters = 0;
            while (!queue.isEmpty()) {
                semesters++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int u = queue.poll();
                    count++;
                    for (int v : adj.get(u)) {
                        if (--inDegree[v] == 0) {
                            queue.offer(v);
                        }
                    }
                }
            }

            return count == n ? semesters : -1;
        }
    }