class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            List<List<Integer>> adj = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] edge : prerequisites) {
                adj.get(edge[1]).add(edge[0]);
                inDegree[edge[0]]++;
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int[] sorted = new int[numCourses];
            int count = 0;

            while (!queue.isEmpty()) {
                int u = queue.poll();
                sorted[count++] = u;

                for (int v : adj.get(u)) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            return count == numCourses ? sorted : new int[0];
        }
    }