/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public ListNode insertionSortList(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                int val = head.val;
                if (list.isEmpty()) {
                    list.add(val);
                } else {
                    list.add(val);
                    int index = list.size() - 1;
                    while (index > 0 && list.get(index - 1) > list.get(index)) {
                        int temp = list.get(index);
                        list.set(index, list.get(index - 1));
                        list.set(index - 1, temp);
                        index--;
                    }
                }
                
                head = head.next;
            }
            
            ListNode result = new ListNode(list.getFirst());
            ListNode prev = result;
            for (int i = 1; i < list.size(); i++) {
                prev.next = new ListNode(list.get(i));
                prev = prev.next;
            }
            
            return result;
        }
}