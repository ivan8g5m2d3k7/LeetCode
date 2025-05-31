class TwoSum {
        List<Integer> list;
        int min;
        int max;

        public TwoSum() {
            this.list = new ArrayList<>();
        }

        public void add(int number) {
            this.list.add(number);
            this.min = Math.min(min, number);
            this.max = Math.max(max, number);
        }

        public boolean find(int value) {
            if (value < 2 * min || value > 2 * max) {
                return false;
            }

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) + list.get(j) == value) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */