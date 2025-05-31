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
    public ListNode middleNode(ListNode head) {
        int count = 0;
            ListNode node = head;
            while (node != null) {
                count++;
                node = node.next;
            }

//            int middle = (count / 2) + 1;
//            int steps = middle - 1;
            int steps = count / 2;
            ListNode result = head;
            for (int i = 0; i < steps; i++) {
                result = result.next;
            }

            return result;
    }
}