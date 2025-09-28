class Solution {
        public int deleteAndEarn(int[] nums) {
            TreeMap<Integer, Integer> numToPoints = new TreeMap<>();
            for (int a : nums) {
                numToPoints.put(a, numToPoints.getOrDefault(a, 0) + a);
            }
            Map<Integer, Integer> maxPoints = new HashMap<>(numToPoints.size());

            for (int a : numToPoints.keySet()) {
                Integer lowerKey = numToPoints.lowerKey(a);
                int val = 0;
                if (lowerKey == null || lowerKey != a - 1) {
                    val = maxPoints.getOrDefault(lowerKey, 0) + numToPoints.get(a);
                } else {
                    val = Math.max(maxPoints.getOrDefault(lowerKey, 0),
                            maxPoints.getOrDefault(numToPoints.lowerKey(lowerKey), 0) + numToPoints.get(a));
                }
                maxPoints.put(a, val);
            }

            return maxPoints.get(numToPoints.lastKey());
        }
    }
