class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> times = new ArrayList<>();
            if (turnedOn > 8) {
                return times;
            }

           for (int i = 0; i < 1 << 10; i++) {
               if (Integer.bitCount(i) == turnedOn && ( (i >>> 6) < 12)
               && (i & 0b111111) < 60) {
                   StringBuilder sb = new StringBuilder();
                   sb.append(i >>> 6).append(":");
                   if ((i & 0b111111) < 10) {
                       sb.append("0");
                   }
                   sb.append(i & 0b111111);
                   
                   times.add(sb.toString());
               }
           }

           return times;
        }
    }