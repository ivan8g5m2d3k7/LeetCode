class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<Integer> elements = new ArrayList<>(arr.length);
            for (int x : arr) {
                elements.add(x);
            }
            Collections.sort(elements);
            
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < elements.size() - 1; i++) {
                min = Math.min(Math.abs(elements.get(i) - elements.get(i + 1)), min);
            }
            
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < elements.size() - 1; i++) {
                if (Math.abs(elements.get(i) - elements.get(i + 1)) == min) {
                    result.add(List.of(elements.get(i), elements.get(i + 1)));
                }
            }
            
            return result;
        }
}