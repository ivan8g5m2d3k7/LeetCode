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
    public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode curr = head;
            ListNode res = curr.next;
            swap(curr, null);
            return res;
        }

        public void swap(ListNode node, ListNode prev) {
            if (node == null || node.next == null) {
                return;
            }

            if (prev != null) {
                prev.next = node.next;
            }
            ListNode next = node.next;
            node.next = next.next;
            next.next = node;

            swap(node.next, node);
        }
}