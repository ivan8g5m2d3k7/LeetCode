class Solution {
        public void cleanRoom(Robot robot) {
//            boolean move();
//            void turnLeft();
//            void turnRight();
//            void clean();
            int[][] directions = new int[][] { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
            Set<Long> visited = new HashSet<>();
            dfs(0, 0, 0, directions, visited, robot);
        }

        public long encode(int i, int j) {
            return ( (long) i << 32) | Integer.toUnsignedLong(j);
        }

        public void dfs(int i, int j, int d, int[][] directions, Set<Long> visited, Robot robot) {
            robot.clean();
            visited.add(encode(i, j));

            for (int k = 0; k < 4; k++) {
                int ni = i + directions[d][0];
                int nj = j + directions[d][1];
                long cell = encode(ni, nj);

                if (!visited.contains(cell) && robot.move()) {
                    dfs(ni, nj, d, directions, visited, robot);

                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }

                d = (d + 1) % 4;
                robot.turnRight();
            }
        }
    }