class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> list = new ArrayList<>();
            int s = 0;
            int n = graph.length;
            int d = n - 1;
            dfs(list, new ArrayList<>(), graph, s, n, d);
            return list;
        }

        public void dfs(List<List<Integer>> list, List<Integer> path, int[][] graph, int s, int n, int d) {
            path.add(s);
            if (s == d) {
                list.add(new ArrayList<>(path));
            } else {
                for (int v : graph[s]) {
                    dfs(list, path, graph, v, n, d);
                }
            }
            
            path.removeLast();
        }
    }