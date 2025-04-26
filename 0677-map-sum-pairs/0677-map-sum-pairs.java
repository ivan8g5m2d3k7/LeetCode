class MapSum {
        private Map<String, Integer> prefixes;
        private Map<String, Integer> words;

        public MapSum() {
            this.prefixes = new HashMap<>();
            this.words = new HashMap<>();
        }

        public void insert(String key, int val) {
            int count = val - this.words.getOrDefault(key, 0);
            this.words.put(key, val);
            
            for (int i = 0; i < key.length(); i++) {
                String current = key.substring(0, i + 1);
                this.prefixes.put(current, this.prefixes.getOrDefault(current, 0) + count);
            }
        }

        public int sum(String prefix) {
            return this.prefixes.getOrDefault(prefix, 0);
        }
    }