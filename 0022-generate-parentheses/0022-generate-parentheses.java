class Solution {
    public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generate("", 1, 0, 0, n, result);
    return result;
}

public void generate(String string, int i, int o, int c, int n, List<String> result) {
    if (i > 2 * n) {
        result.add(string);
        return;
    }

    if (o < n) {
        generate(string + "(", i + 1, o + 1, c, n, result);
    }
    if (c < o) {
        generate(string + ")", i + 1, o, c + 1, n, result);
    }
}
}