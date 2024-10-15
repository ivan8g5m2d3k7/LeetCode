class Solution {
    public int firstUniqChar(String s) {
            Map<Character, Boolean> charToIsUnique = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (charToIsUnique.containsKey(c)) {
                    charToIsUnique.put(c, false);
                } else {
                    charToIsUnique.put(c, true);
                }
            }
            
            Character unique = null;
            for (Map.Entry<Character, Boolean> entry : charToIsUnique.entrySet()) {
                if (entry.getValue()) {
                    unique = entry.getKey();
                    break;
                }
            }
            
            if (unique == null) {
                return -1;
            } else {
                return s.indexOf(unique);
            }
        }
}