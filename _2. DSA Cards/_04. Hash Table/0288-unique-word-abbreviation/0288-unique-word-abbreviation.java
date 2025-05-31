class ValidWordAbbr {
            private Map<String, HashSet<String>> map;

            public ValidWordAbbr(String[] dictionary) {
                this.map = new HashMap<>();
                for (String word : dictionary) {
                    String key = this.getKey(word);
                    map.putIfAbsent(key, new HashSet<>());
                    map.get(key).add(word);
                }
            }

            public boolean isUnique(String word) {
                String key = this.getKey(word);
                if (!map.containsKey(key)) {
                    return true;
                } else return map.get(key).size() == 1 && map.get(key).iterator().next().equals(word);
            }

            public String getKey(String word) {
                StringBuilder sb = new StringBuilder(String.valueOf(word.charAt(0)));
                if (word.length() > 2) {
                    sb.append(word.length() - 2);
                }
                sb.append(word.charAt(word.length() - 1));
                return sb.toString();
            }
        }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */