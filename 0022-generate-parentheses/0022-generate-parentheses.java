class Solution {
    public List<String> generateParenthesis(int n) {
//            Input: n = 3
//            Output: ["((()))","(()())","(())()","()(())","()()()"]
            Set<String> set = new HashSet<>();
            generate("", 1, 0, 0, n, set);
            return set.stream().toList();
        }

        public void generate(String string, int i, int o, int c, int n, Set<String> set) {
            if (i > 2 * n) {
                set.add(string);
                return;
            }
            
            if (o < n) {
                generate(string + "(", i + 1, o + 1, c, n, set);
            }
            if (c < o && o <= n) {
                generate(string + ")", i + 1, o, c + 1, n, set);
            }
        }
}