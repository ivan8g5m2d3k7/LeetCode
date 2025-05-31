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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = null;
            ListNode i = null;
            ListNode j = null;
            if (list1 == null && list2 == null) {
                return null;
            } else if (list1 == null && list2 != null) {
                return list2;
            } else if (list1 != null && list2 == null) {
                return list1;
            } else if (list1.val <= list2.val) {
                head = list1;
                i = list1.next;
                j = list2;
            } else {
                head = list2;
                i = list1;
                j = list2.next;
            }
            ListNode current = head;

            while (i != null || j != null) {
                if (i == null || (j != null && i.val > j.val)) {
                    current.next = j;
                    current = j;
                    j = j.next;
                } else {
                    current.next = i;
                    current = i;
                    i = i.next;
                } 
            }
            
            return head;
        }
}