class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
            boolean[] isPresent = new boolean[nums.length + 1];
            for (int num : nums) {
                isPresent[num] = true;
            }

            return IntStream.range(1, isPresent.length)
                    .filter(i -> !isPresent[i]).boxed().toList();
        }
}