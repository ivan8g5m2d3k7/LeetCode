class Solution {
        public int minMeetingRooms(int[][] intervals) {
            PriorityQueue<int[]> startMinHeap = new PriorityQueue<>(intervals.length,
                   Comparator.comparingInt(a -> a[0]));
            PriorityQueue<int[]> endMinHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            int count = 0;
            int max = Integer.MIN_VALUE;
            for (int[] meeting : intervals) {
                startMinHeap.offer(meeting);
            }

            while (!startMinHeap.isEmpty()) {
                int[] curr = startMinHeap.poll();
                while (!endMinHeap.isEmpty() && endMinHeap.peek()[1] <= curr[0]) {
                    count--;
                    endMinHeap.poll();
                }
                count++;
                endMinHeap.offer(curr);

                max = Math.max(max, count);
            }

            return max > 0 ? max : 1;
        }
    }