class Solution {
     public int numSquares(int n) {
            Set<Integer> squares = new LinkedHashSet<>();
            for (int i = 1; (i * i) <= n; i++) {
                squares.add(i * i);
            }
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(n);
            int result = 0;

            while (!queue.isEmpty()) {
                result++;
                Deque<Integer> next = new ArrayDeque<>();

                for (int a : queue) {
                    for (int s : squares) {
                        if (a == s) {
                            return result;
                        } else if (a > s) {
                            next.offer(a - s);
                        } else {
                            break;
                        }
                    }
                }

                queue = next;
            }

            return -1;
        }
}