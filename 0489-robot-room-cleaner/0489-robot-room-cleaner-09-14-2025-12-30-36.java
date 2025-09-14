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

        public void dfs(int i, int j, int d, int[][] directions, Set<Long> visited, Robot robot) {
            visited.add(( (long) i << 32) | Integer.toUnsignedLong(j));
            robot.clean();

            for (int k = 0; k < 4; k++) {
                int r = i + directions[d][0];
                int c = j + directions[d][1];
                long cell = ( (long) r << 32) | Integer.toUnsignedLong(c);

                if (!visited.contains(cell) && robot.move()) {
                    dfs(r, c, d, directions, visited, robot);

//                    visited.remove(cell);
                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }

                robot.turnRight();
                d = (d + 1) % 4;
            }
        }
    }