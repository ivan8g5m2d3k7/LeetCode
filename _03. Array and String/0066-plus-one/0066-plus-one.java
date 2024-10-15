class Solution {
    public int[] plusOne(int[] digits) {
            boolean increment = false;
            List<Integer> list = new ArrayList<>(digits.length + 1);
            for (int i = digits.length - 1; i >= 0; i--) {
                int num = digits[i];
                if (i == digits.length - 1) {
                    num += 1;
                }

                if (increment) {
                    num += 1;
                    increment = false;
                }

                if (num == 10) {
                    num = 0;
                    increment = true;
                }
                list.add(num);
            }

            if (increment) {
                list.add(1);
            }

            int[] result = new int[list.size()];
            int j = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                result[j++] = list.get(i);
            }

            return result;
        }
}