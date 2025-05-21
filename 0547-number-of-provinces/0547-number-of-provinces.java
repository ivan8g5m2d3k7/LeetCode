class Solution {

        public class DisjointSet {
            private int[] parent;
            private int[] rank;

            public DisjointSet(int n) {
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
                this.rank = new int[n];
            }

            public int getLength() {
                return this.parent.length;
            }

            public int find(int x) {
                 if (parent[x] != x) {
                     parent[x] = find(parent[x]);
                 }
                 return parent[x];
            }

            public boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }

            public void union(int x, int y) {
                if (isConnected(x, y)) {
                    return;
                }
                int px = find(x);
                int py = find(y);

                if (this.rank[px] < this.rank[py]) {
                    this.parent[px] = py;
                } else if (this.rank[px] > this.rank[py]) {
                    this.parent[py] = px;
                } else {
                    this.parent[py] = px;
                    this.rank[px]++;
                }
            }
        }

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            DisjointSet ds = new DisjointSet(n);
            int num = n;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isConnected[i][j] == 1 && ds.find(i) != ds.find(j)) {
                        ds.union(i, j);
                        num--;
                    }
                }
            }

            return num;
        }
    }