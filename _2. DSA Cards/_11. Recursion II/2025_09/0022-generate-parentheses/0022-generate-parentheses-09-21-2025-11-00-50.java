class Solution {

        List<String> combinations = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n, 0, 0, "");
            return combinations;
        }

        public void dfs(int n, int open, int closed, String path) {
            if (path.length() == 2 * n) {
                combinations.add(path);
                return;
            }
            
            if (open < n) {
                dfs(n, open + 1, closed, path + "(");
            }
            if (closed < open && closed < n) {
                dfs(n, open, closed + 1, path + ")");
            }
            
        }
    }