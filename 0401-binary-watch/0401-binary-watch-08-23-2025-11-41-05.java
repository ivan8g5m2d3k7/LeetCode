class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> times = new ArrayList<>();
            if (turnedOn > 8) {
                return times;
            }

            int n = 10;
            for (int m = 0; m < 60; m++) {

                for (int h = 0; h < 12; h++) {
                    if (Integer.bitCount(m) + Integer.bitCount(h) == turnedOn) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(h).append(":");
                        if (m < 10) {
                            sb.append(0);
                        }
                        sb.append(m);

                        times.add(sb.toString());
                    }
                }
            }

            return times;
        }
    }