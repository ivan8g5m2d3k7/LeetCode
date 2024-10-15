class Solution {
     public List<List<String>> groupStrings(String[] strings) {
            Map<List<Integer>, List<String>> map = new HashMap<>();
            for (String s : strings) {
                List<Integer> key = new ArrayList<>(s.length() - 1);
                for (int i = 1; i < s.length(); i++) {
                    char current = s.charAt(i);
                    char prev = s.charAt(i - 1);
                    int x = (current - prev + 26) % 26;
                    key.add(x);
                }
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(s);
            }

            return map.values().stream().toList();
        }
}