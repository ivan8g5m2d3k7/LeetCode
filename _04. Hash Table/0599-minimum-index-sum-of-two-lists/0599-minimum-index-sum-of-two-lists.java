class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
            Map<Integer, List<String>> isumToStrings = new TreeMap<>();
            Map<String, Integer> included1 = new HashMap<>(list1.length);
            //2000
            for (int i = 0; i < list1.length; i++) {
                included1.put(list1[i], i);
            }

            for (int i = 0; i < list2.length; i++) {
                if (included1.containsKey(list2[i])) {
                    int index = i + included1.get(list2[i]);
                    isumToStrings.putIfAbsent(index, new ArrayList<>());
                    isumToStrings.get(index).add(list2[i]);
                }
            }

            return isumToStrings.values().iterator().next().toArray(new String[0]);
        }
}