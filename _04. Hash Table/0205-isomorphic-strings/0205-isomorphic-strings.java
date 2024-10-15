class Solution {
    public boolean isIsomorphic(String s, String t) {
            Map<Character, List<Integer>> charToIndices1 = new LinkedHashMap<>();
            Map<Character, List<Integer>> charToIndices2 = new LinkedHashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char first = s.charAt(i);
                char second = t.charAt(i);

                if (charToIndices1.containsKey(first)) {
                    charToIndices1.get(first).add(i);
                } else {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    charToIndices1.put(first, list1);
                }

                if (charToIndices2.containsKey(second)) {
                    charToIndices2.get(second).add(i);
                } else {
                    List<Integer> list2 = new ArrayList<>();
                    list2.add(i);
                    charToIndices2.put(second, list2);
                }
            }

            if (charToIndices1.size() != charToIndices2.size()) {
                return false;
            }
            
            List<List<Integer>> first = charToIndices1.values().stream().toList();
            List<List<Integer>> second = charToIndices2.values().stream().toList();
            
            for (int i = 0; i < first.size(); i++) {
                if (first.get(i).size() != second.get(i).size()) {
                    return false;
                }
                for (int j = 0; j < first.get(i).size(); j++) {
                    if (!first.get(i).get(j).equals(second.get(i).get(j))) {
                        return false;
                    }
                }
            }

            return true;
        }
}