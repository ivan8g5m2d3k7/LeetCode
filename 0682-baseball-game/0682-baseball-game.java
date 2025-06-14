class Solution {
        public int calPoints(String[] operations) {
            List<Integer> list = new ArrayList<>();
            for (String str : operations) {
                if (str.equals("+")) {
                    int num = list.get(list.size() - 1) + list.get(list.size() - 2);
                    list.add(num);
                } else if (str.equals("D")) {
                    list.add(2 * list.get(list.size() - 1));
                } else if (str.equals("C")) {
                    list.removeLast();
                } else {
                    list.add(Integer.parseInt(str));
                }
            }
            
            return list.stream().mapToInt(Integer::intValue).sum();
        }
    }