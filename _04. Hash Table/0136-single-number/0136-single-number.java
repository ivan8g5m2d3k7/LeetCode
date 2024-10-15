class Solution {
    public int singleNumber(int[] nums) {
            Set<Integer> set = new HashSet<>((nums.length / 2) + 1);
            for (int k : nums) {
                if (set.contains(k)) {
                    set.remove(k);
                } else {
                    set.add(k);
                }
            }
            
            return set.iterator().next();
        }
}