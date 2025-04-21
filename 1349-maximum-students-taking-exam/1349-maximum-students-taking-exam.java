class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] validSeats = new int[m];

        // Convert seat rows to bitmask where 1 = usable seat
        for (int i = 0; i < m; ++i) {
            int mask = 0;
            for (int j = 0; j < n; ++j) {
                mask <<= 1;
                if (seats[i][j] == '.') {
                    mask |= 1;
                }
            }
            validSeats[i] = mask;
        }

        // DP[row][prevRowMask] = max students placed up to this row
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0); // Base case: no students placed initially

        for (int row = 0; row < m; ++row) {
            Map<Integer, Integer> newDp = new HashMap<>();
            List<Integer> currRowValidMasks = generateValidMasks(validSeats[row], n);
            for (int currMask : currRowValidMasks) {
                for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                    int prevMask = entry.getKey();
                    int prevCount = entry.getValue();
                    if ((currMask & (prevMask << 1)) == 0 && (currMask & (prevMask >> 1)) == 0) {
                        int currCount = Integer.bitCount(currMask);
                        newDp.put(currMask, Math.max(newDp.getOrDefault(currMask, 0), prevCount + currCount));
                    }
                }
            }
            dp = newDp;
        }

        int max = 0;
        for (int val : dp.values()) {
            max = Math.max(max, val);
        }
        return max;
    }

    // Generate all valid placements of students for a given row
    private List<Integer> generateValidMasks(int seatMask, int n) {
        List<Integer> result = new ArrayList<>();
        dfs(seatMask, n, 0, 0, result);
        return result;
    }

    // DFS to try placing students at valid positions in the row
    private void dfs(int seatMask, int n, int pos, int currMask, List<Integer> result) {
        if (pos == n) {
            result.add(currMask);
            return;
        }
        // Skip current seat
        dfs(seatMask, n, pos + 1, currMask, result);
        // Try to place student at pos if:
        // - seat is available
        // - no student to the left
        if (((seatMask >> (n - 1 - pos)) & 1) == 1 && 
            (pos == 0 || ((currMask >> (pos - 1)) & 1) == 0)) {
            dfs(seatMask, n, pos + 1, currMask | (1 << pos), result);
        }
    }
}