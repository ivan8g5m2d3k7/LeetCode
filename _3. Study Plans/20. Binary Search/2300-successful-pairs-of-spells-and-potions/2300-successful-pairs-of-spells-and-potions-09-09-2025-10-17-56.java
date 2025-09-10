class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int[] pairs = new int[spells.length];

            for (int i = 0; i < spells.length; i++) {
                int target = (int) Math.ceil((double) success / spells[i]);
                int left = 0;
                int right = potions.length;

                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (potions[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                if (left < potions.length) {
                    pairs[i] = potions.length - left;
                }
            }

            return pairs;
        }
    }