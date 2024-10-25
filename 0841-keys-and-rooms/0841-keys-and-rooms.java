class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int v = 1;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Deque<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(rooms.get(0));

        while (!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            for (int room : curr) {
                if (!visited[room]) {
                    queue.offer(rooms.get(room));
                    v++;
                    visited[room] = true;
                }
            }
        }

        return v == visited.length;
    }
}