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
    public ListNode removeNthFromEnd(ListNode head, int n) {
            Map<Integer, ListNode> map = new HashMap<>();
            int count = 0;
            int size = 0;
            ListNode current = head;
            while (current != null) {
                size++;
                map.put(count++, current);
                current = current.next;
            }

            if (size == 1 && n == 1) {
                return null;
            }

            int deleteIndex = size - n;
            int prevIndex = deleteIndex - 1;
            int nextIndex = deleteIndex + 1;
            
            ListNode delete = map.get(deleteIndex);
            ListNode prev = map.get(prevIndex);
            ListNode next = map.get(nextIndex);
            
            if (prev == null) {
                delete.next = null;
                head = next;
            } else {
                prev.next = delete.next;
                if (delete.next != null) {
                    delete.next = null;
                }
            }
            

            return head;
        }
}