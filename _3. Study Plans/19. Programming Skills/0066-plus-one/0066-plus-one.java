class Solution {
        public int[] plusOne(int[] digits) {
            List<Integer> list = new ArrayList<>(digits.length + 1);
            int carry = 1;
            boolean flag = false;

            for (int i = digits.length - 1; i >= 0; i--) {
                int sum = digits[i] + carry;
                if (carry != 0 && sum > 9) {
                    sum = 0;
                    carry = 1;
                } else if (carry != 0) {
                    carry = 0;
                }
                list.add(sum);

                if (i == 0 && carry > 0) {
                    flag = true;
                }
            }

            if (flag) {
                list.add(1);
            }

            int[] num = new int[list.size()];
            int j = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                num[j++] = list.get(i);
            }

            return num;
        }
    }