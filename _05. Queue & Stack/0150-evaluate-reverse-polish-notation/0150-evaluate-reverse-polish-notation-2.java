class Solution {
    public int evalRPN(String[] tokens) {
            Deque<Integer> operands = new ArrayDeque<>();
            Set<String> operators = new HashSet<>(List.of("+", "-", "*", "/"));
            for (String curr : tokens) {
                if (operators.contains(curr)) {
                    int right = operands.pop();
                    int left = operands.pop();
                    int res;
                    if (curr.equals("+")) {
                        res = left + right;
                    } else if (curr.equals("-")) {
                        res = left - right;
                    } else if (curr.equals("*")) {
                        res = left * right;
                    } else {
                        res = left / right;
                    }

                    operands.push(res);
                } else {
                    operands.push(Integer.parseInt(curr));
                }
            }
            
            return operands.pop();
        }
}