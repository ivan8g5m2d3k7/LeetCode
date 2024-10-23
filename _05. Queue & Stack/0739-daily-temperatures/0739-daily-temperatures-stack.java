class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                        int prev = stack.pop();
                        res[prev] = i - prev;
                    }

                    stack.push(i);
                }
            }

            return res;
        }
}