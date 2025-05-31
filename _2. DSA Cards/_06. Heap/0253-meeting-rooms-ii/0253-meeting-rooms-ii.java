class Solution {
    public int minMeetingRooms(int[][] intervals) {
//            Example 1:
//
//            Input: intervals = [[0,30],[5,10],[15,20]]
//            Output: 2
//            Example 2:
//
//            Input: intervals = [[7,10],[2,4]]
//            Output: 1

            PriorityQueue<int[]> startHeap = new PriorityQueue<>(intervals.length, (a, b) -> a[0] - b[0]);
            PriorityQueue<int[]> endHeap = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);
            for (int[] m : intervals) {
                startHeap.offer(m);
                endHeap.offer(m);
            }
            int occupied = 1;
            startHeap.poll();

            while (!startHeap.isEmpty()) {
                if (startHeap.peek()[0] < endHeap.peek()[1]) {
                    occupied++;
                    startHeap.poll();
                } else {
                    endHeap.poll();
                    startHeap.poll();
                }
            }
            
            return occupied;
        }
}