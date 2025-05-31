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
    private ListNode res;
        public ListNode reverseList(ListNode head) {
            reverse(head, null);
            return res;
        }

        public void reverse(ListNode node, ListNode prev) {
            if (node == null) {
                this.res = prev;
                return;
            }
            ListNode next = node.next;
            node.next = prev;
            reverse(next, node);
        }
}