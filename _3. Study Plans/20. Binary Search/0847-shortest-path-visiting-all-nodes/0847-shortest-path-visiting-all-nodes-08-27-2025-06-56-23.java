class Solution {
        public int shortestPathLength(int[][] graph) {
            if (graph.length == 1) {
                return 0;
            }
            if (graph.length == 2) {
                return 1;
            }
            int fullMask = (1 << graph.length) - 1;
            boolean[][] visited = new boolean[graph.length][1 << graph.length];

            //  [node, pathLength, stateMask]
            Deque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < graph.length; i++) {
                queue.offer(new int[]{i, 0, 1 << i});
                visited[i][1 << i] = true;
            }

            while (true) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] current = queue.poll();
                    int node = current[0];
                    int pathLength = current[1];
                    int stateMask = current[2];

                    for (int next : graph[node]) {
                        int nextState = stateMask | (1 << next);
                        if (!visited[next][nextState]) {
                            if (nextState == fullMask) {
                                return pathLength + 1;
                            }

                            visited[next][nextState] = true;
                            queue.offer(new int[]{next, pathLength + 1, nextState});
                        }
                    }
                }
            }
        }
    }