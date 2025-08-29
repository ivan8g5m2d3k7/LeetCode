class TimeMap {

        Map<String, List<String[]>> map = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            this.map.putIfAbsent(key, new ArrayList<>());
            this.map.get(key).add(new String[] {String.valueOf(timestamp), value});
//            this.map.get(key).sort(Comparator.comparingInt(a -> Integer.parseInt(a[0])));
        }

        public String get(String key, int timestamp) {
            List<String[]> list = this.map.get(key);
            if (list == null) {
                return "";
            }
            int left = 0;
            int right = list.size();

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (Integer.parseInt(list.get(mid)[0]) < timestamp) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == list.size()) {
                return list.getLast()[1];
            } else {
                if (timestamp == Integer.parseInt(this.map.get(key).get(left)[0])) {
                    return this.map.get(key).get(left)[1];
                } else {
                    if (left == 0) {
                        return "";
                    }
                    return this.map.get(key).get(left - 1)[1];
                }
            }
        }
    }