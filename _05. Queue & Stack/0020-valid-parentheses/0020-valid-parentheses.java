class Solution {
     public boolean isValid(String s) {
            if (s.isEmpty()) {
                return true;
            } else if (s.length() == 1) {
                return false;
            }

            Deque<Character> opened = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '{' || c == '[' || c == '(') {
                    opened.push(c);
                } else {
                    if (opened.isEmpty()) {
                        return false;
                    }

                    char open = opened.pop();
                    if ((open == '{' && c != '}') || (open == '[' && c != ']') ||
                            (open == '(' && c != ')')) {
                        return false;
                    }
                }
            }

            return opened.isEmpty();
        }
}