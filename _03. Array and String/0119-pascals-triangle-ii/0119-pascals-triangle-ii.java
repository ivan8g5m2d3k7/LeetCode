class Solution {
    public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> triangle = new ArrayList<>(rowIndex + 1);
            List<Integer> zero = List.of(1);
            List<Integer> one = List.of(1, 1);
            triangle.add(zero);
            triangle.add(one);

            for (int i = 2; i <= rowIndex; i++) {
                List<Integer> prev = triangle.get(i - 1);
                List<Integer> current = new ArrayList<>(rowIndex + 1);
                current.add(1);
                for (int j = 1; j <= i - 1; j++) {
                    current.add(prev.get(j - 1) + prev.get(j));
                }
                current.add(1);

                triangle.add(current);
            }

            return triangle.get(rowIndex);
        }
}