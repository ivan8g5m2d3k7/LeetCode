class Solution {
        public int getIndex(ArrayReader reader) {
            int left = 0;
            int right = reader.length() - 1;

            while (left < right) {
                int length = right - left + 1;
                if (length % 2 == 1) {
                    // 0 1 2 3 4 , length = 5
                    int lm = left + (length / 2) - 1;
                    int rm = lm + 2;
                    int comp = reader.compareSub(left, lm, rm, right);

                    if (comp == 0) {
                        return lm + 1;
                    } else if (comp < 0) {
                        left = rm;
                    } else {
                        right = lm;
                    }
                } else {
                    // 0 1 2 3 4 5 , length = 6
                    int rm = left + (length / 2);
                    int lm = rm - 1;
                    int comp = reader.compareSub(left, lm, rm, right);

                    if (comp < 0) {
                        left = rm;
                    } else {
                        right = lm;
                    }
                }
            }

            return left;
        }
    }