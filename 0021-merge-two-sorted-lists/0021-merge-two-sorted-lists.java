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
    private ListNode dummy = new ListNode(-1000);
        private ListNode prev;

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return dummy.next;
            } else if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            }

            if (list1.val < list2.val) {
                dummy.next = list1;
                prev = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                prev = list2;
                list2 = list2.next;
            }

            merge(list1, list2);
            return dummy.next;
        }

        public void merge(ListNode f, ListNode s) {
            if (f == null && s == null) {
                return;
            }
            if (s == null || ((f != null) && f.val < s.val)) {
                prev.next = f;
                prev = f;
                f = f.next;
            } else if (f == null || ( (s != null) && (s.val <= f.val) ) ) {
                prev.next = s;
                prev = s;
                s = s.next;
            }

            merge(f, s);
        }
}