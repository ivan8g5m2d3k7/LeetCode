class Solution {
     public int openLock(String[] deadends, String target) {
            int n = 0;
            String curr = "0000";
            Set<String> visited = new HashSet<>(List.of(deadends));
            if (visited.contains(curr)) {
                return -1;
            }

            Map<Character, Character> increment = new HashMap<>(10);
            Map<Character, Character> decrement = new HashMap<>(10);
            for (int i = 0; i <= 9; i++) {
                increment.put(String.valueOf(i).charAt(0), this.increment(i));
                decrement.put(String.valueOf(i).charAt(0), this.decrement(i));
            }
            Deque<String> queue = new ArrayDeque<>();
            queue.offer(curr);
            visited.add(curr);

            while (!queue.isEmpty()) {
                int count = queue.size();
                for (int j = 0; j < count; j++) {
                    curr = queue.poll();
                    if (curr.equals(target)) {
                        return n;
                    }

                    for (int i = 0; i < 4; i++) {
                        StringBuilder prev = new StringBuilder(curr);
                        StringBuilder next = new StringBuilder(curr);
                        prev.setCharAt(i, decrement.get(prev.charAt(i)));
                        next.setCharAt(i, increment.get(next.charAt(i)));

                        if (!visited.contains(prev.toString())) {
                            queue.offer(prev.toString());
                            visited.add(prev.toString());
                        }
                        if (!visited.contains(next.toString())) {
                            queue.offer(next.toString());
                            visited.add(next.toString());
                        }
                    }
                }
                n++;
            }

            return -1;
        }

        public char increment(int c) {
            int a = c + 1;
            if (a >= 10) {
                a = 0;
            }

            return String.valueOf(a).charAt(0);
        }

        public char decrement(int c) {
            int a = c - 1;
            if (a < 0) {
                a = 9;
            }

            return String.valueOf(a).charAt(0);
        }
}