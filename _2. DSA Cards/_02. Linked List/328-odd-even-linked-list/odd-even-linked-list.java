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
    public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode evenHead = head.next;
            int index = 3;
            if (evenHead == null || evenHead.next == null) {
                return head;
            }
            ListNode current = evenHead.next;
            ListNode odd = head;
            ListNode even = evenHead;

            while (true) {
                if (index % 2 == 1) {
                    odd.next = current;
                    odd = current;
                } else {
                    even.next = current;
                    even = current;
                }

                if (current.next == null) {
                    break;
                }

                current = current.next;
                index++;
            }
            
            even.next = null;
            odd.next = evenHead;
            return head;
        }
}