class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums.length == 1 || k == 0) {
                return false;
            }

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.get(nums[i]).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(nums[i], list);
                }
            }

            for (List<Integer> list : map.values()) {
                if (list.size() < 2) {
                    continue;
                }

                for (int i = 0; i <= list.size() - 2; i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (Math.abs(list.get(i) - list.get(j)) <= k) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
}