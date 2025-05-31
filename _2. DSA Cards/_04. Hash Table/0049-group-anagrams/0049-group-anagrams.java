class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String x : strs) {
                char[] symbols = x.toCharArray();
                Arrays.sort(symbols);
                String key = Arrays.toString(symbols);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(x);
            }

            List<List<String>> result = new ArrayList<>(map.size());
            result.addAll(map.values());
            return result;
        }
}