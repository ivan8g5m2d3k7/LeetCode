class DisjointSetBySize {
        int[] parent;
        int[] size;

        public DisjointSetBySize(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
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
            // Union by Size: attach smaller tree under larger tree
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }

        public int getSize(int x) {
            return this.size[x];
        }
    }

    class Solution {
        public int earliestAcq(int[][] logs, int n) {
            Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
            DisjointSetBySize ds = new DisjointSetBySize(n);
            int groups = n;
            for (int[] log : logs) {
                if (!ds.connected(log[1], log[2])) {
                    groups--;
                }
                ds.union(log[1], log[2]);
                if (groups == 1) {
                    return log[0];
                }
            }
            return -1;
        }
    }