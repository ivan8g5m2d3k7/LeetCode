class Solution {
     private List<String> result = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();
        private Map<Integer, List<Integer>> digitToLetters = new HashMap<>(8);

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return result;
            }

            for (int i = 2; i <= 9; i++) {
                List<Integer> curr = new ArrayList<>(4);
                if (i <= 6) {
                    for (int j = 0; j < 3; j++) {
                        curr.add(97 + ((i - 2) * 3) + j);
                    }
                } else if (i == 7) {
                    for (int j = 0; j < 4; j++) {
                        curr.add(97 + ((i - 2) * 3) + j);
                    }
                } else if (i == 8) {
                    for (int j = 0; j < 3; j++) {
                        curr.add(116 + j);
                    }
                } else if (i == 9) {
                    for (int j = 0; j < 4; j++) {
                        curr.add(119 + j);
                    }
                }

                digitToLetters.put(i, curr);
            }

            combine(digits);
            return result;
        }

        public void combine(String digits) {
            if (sb.length() == digits.length()) {
                result.add(sb.toString());
                return;
            }

            int digit = Integer.parseInt(String.valueOf(digits.charAt(sb.length())));
            List<Integer> nums = digitToLetters.get(digit);

            for (int num : nums) {
                    sb.append((char) num);
                    combine(digits);
                    sb.deleteCharAt(sb.length() - 1);
            }
        }
}