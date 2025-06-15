class Solution {
        public boolean isRobotBounded(String instructions) {
            int row = 0, col = 0;
            char dir = 'N';
            Map<Character, Character> left = new HashMap<>(4);
            left.put('N', 'W');
            left.put('W', 'S');
            left.put('S', 'E');
            left.put('E', 'N');
            Map<Character, Character> right = new HashMap<>(4);
            right.put('N', 'E');
            right.put('E', 'S');
            right.put('S', 'W');
            right.put('W', 'N');

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < instructions.length(); j++) {
                    char c = instructions.charAt(j);
                    if (c == 'L') {
                        dir = left.get(dir);
                    } else if (c == 'R') {
                        dir = right.get(dir);
                    } else if (c == 'G') {
                        if (dir == 'N') {
                            row--;
                        } else if (dir == 'S') {
                            row++;
                        } else if (dir == 'E') {
                            col--;
                        } else if (dir == 'W') {
                            col++;
                        }
                    }
                }

                if (row == 0 && col == 0) {
                    return true;
                }
            }

            return false;
        }
    }