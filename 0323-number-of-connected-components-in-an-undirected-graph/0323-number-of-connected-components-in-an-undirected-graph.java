class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int N) {
            parent = new int[N];
            rank   = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                rank[i]   = 0;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                // Path Compression: flatten the tree by setting parent directly to root
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            // Union by Rank: attach smaller rank tree under larger rank tree
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    class Solution {
        public int countComponents(int n, int[][] edges) {
            DisjointSet ds = new DisjointSet(n);
            int count = n;
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                if (!ds.connected(a, b)) {
                    ds.union(a, b);
                    count--;
                }
            }
            
            return count;
        }
    }