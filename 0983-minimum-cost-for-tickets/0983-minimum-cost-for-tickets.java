class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            // dp[i] = min cost to travel up to day i, inclusive
            int[] dp = new int[366];
            dp[days[0]] = costs[0];
            Set<Integer> set = new HashSet<>(days.length);
            for (int d : days) {
                set.add(d);
            }

            for (int i = 1; i <= days[days.length - 1]; i++) {
                if (set.contains(i)) {
                    int one = dp[i - 1] + costs[0];
                    int seven = dp[Math.max(0, i - 7)] + costs[1];
                    int thirty = dp[Math.max(0, i - 30)] + costs[2];
                    dp[i] = Math.min(one, Math.min(seven, thirty));
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            
            return dp[days[days.length - 1]];
        }
    }