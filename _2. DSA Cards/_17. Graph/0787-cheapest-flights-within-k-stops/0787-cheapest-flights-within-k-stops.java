class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            Map<Integer, List<Integer[]>> adj = new HashMap<>(n);
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            for (int[] edge : flights) {
                adj.putIfAbsent(edge[0], new ArrayList<>());
                adj.get(edge[0]).add(new Integer[] {edge[1], edge[2]});
            }
           Deque<Integer[]> queue = new ArrayDeque<>();
            queue.offer(new Integer[] {src, 0});
            int levels = 0;

            while (!queue.isEmpty() && levels++ <= k) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer[] pair = queue.poll();
                    int u = pair[0];
                    int currDist = pair[1];
                    if (!adj.containsKey(u)) {
                        continue;
                    }

                    for (Integer[] edge : adj.get(u)) {
                        int v = edge[0];
                        int w = edge[1];
                        if (currDist + w < dist[v]) {
                            dist[v] = currDist + w;
                            queue.offer(new Integer[] {v, dist[v]});
                        }
                    }
                }
            }

            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        }
    }