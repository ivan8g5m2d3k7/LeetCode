class Solution {
        Set<Long> visited = new HashSet<>();
        int[][] directions = new int[][] { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        public void cleanRoom(Robot robot) {
//            boolean move();
//            void turnLeft();
//            void turnRight();
//            void clean();
//            0 - wall, 1 - empty cell
            dfs(robot, 0, 0, 0);
        }

        public long encode(int i, int j) {
            return ( (long) i << 32) | Integer.toUnsignedLong(j);
        }

        public void dfs(Robot robot, int i, int j, int d) {
            robot.clean();
            this.visited.add(encode(i, j));

            for (int k = 0; k < 4; k++) {
                int nd = (d + k) % 4;
                int ni = i + this.directions[nd][0];
                int nj = j + this.directions[nd][1];
                long cell = encode(ni, nj);

                if (!this.visited.contains(cell) && robot.move()) {
                    dfs(robot, ni, nj, nd);

                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }

                robot.turnRight();
            }
        }
    }