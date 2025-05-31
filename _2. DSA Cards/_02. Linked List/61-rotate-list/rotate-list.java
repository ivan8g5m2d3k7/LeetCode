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
    public ListNode rotateRight(ListNode head, int k) {
            List<ListNode> list = new ArrayList<>();
            if (head == null || head.next == null || k == 0) {
                return head;
            }

            ListNode current = head;
            while (current != null) {
                list.add(current);
                current = current.next;
            }

            int size = list.size();
            if (k >= size) {
                k = k % size;
                if (k == 0) {
                    return head;
                }
            }

            ListNode prev = list.get(size - k - 1);
            ListNode start = list.get(size - k);
            ListNode end = list.get(size - 1);

            prev.next = null;
            end.next = head;
            return start;
        }
}