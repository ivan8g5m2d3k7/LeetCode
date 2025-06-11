class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
           List<List<Integer[]>> adj = new ArrayList<>(n + 1);
           for (int i = 0; i <= n; i++) {
               adj.add(new ArrayList<>());
           }
           for (int[] edge : times) {
               adj.get(edge[0]).add(new Integer[]{edge[1], edge[2]});
           }
           PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
           pq.offer(new Integer[] {k, 0});
           int[] dist = new int[n + 1];
           Arrays.fill(dist, Integer.MAX_VALUE);
           dist[k] = 0;
           dist[0] = -1;

           while (!pq.isEmpty()) {
               Integer[] pair = pq.poll();
               int u = pair[0], currentTime = pair[1];
               if (dist[u] < currentTime) {
                   continue;
               }

               for (Integer[] edge : adj.get(u)) {
                   int v = edge[0], w = edge[1];
                   if (currentTime + w < dist[v]) {
                       dist[v] = currentTime + w;
                       pq.offer(new Integer[] {v, dist[v]});
                   }
               }
           }

           int max = Arrays.stream(dist).max().getAsInt();
           return max == Integer.MAX_VALUE ? -1 : max;
        }
    }