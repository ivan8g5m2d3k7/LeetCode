class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int trimLength = queries[i][1];
            int k = queries[i][0];

            String[][] matrix = new String[nums.length][2];

            for (int j = 0; j < nums.length; j++) {
                String trimmedNum = nums[j].substring(nums[j].length() - trimLength);
                matrix[j] = new String[]{trimmedNum, String.valueOf(j)};
            }

            Arrays.sort(matrix, (a, b) -> {
                int cmp = a[0].compareTo(b[0]); // Lexicographical comparison
                return (cmp != 0) ? cmp : Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
            });

            result[i] = Integer.parseInt(matrix[k - 1][1]); // Convert index back to int
        }

        return result;
    }
}