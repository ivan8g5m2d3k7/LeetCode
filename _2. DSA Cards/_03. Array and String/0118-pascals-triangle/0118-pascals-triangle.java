class Solution {
    public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>(numRows);
            List<Integer> one = List.of(1);
            result.add(one);
            if (numRows <= 1) {
                return result;
            }
            
            List<Integer> two = List.of(1, 1);
            result.add(two);

            for (int r = 3; r <= numRows; r++) {
                List<Integer> row = new ArrayList<>(r);
                row.add(1);
                List<Integer> prev = result.get(r - 2);
                for (int i = 1; i <= r - 2; i++) {
                    row.add(prev.get(i - 1) + prev.get(i));
                }
                row.add(1);
                row.reversed();
                result.add(row);
            }

            result.reversed();
            return result;
        }
}