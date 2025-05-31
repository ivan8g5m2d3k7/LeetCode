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
    public ListNode mergeKLists(ListNode[] lists) {
            List<ListNode> nodes = new ArrayList<>();
            for (ListNode head : lists) {
                ListNode current = head;
                while (current != null) {
                    nodes.add(current);
                    current = current.next;
                }
            }

            if (nodes.isEmpty()) {
                return null;
            }

            nodes.sort(Comparator.comparing(n -> n.val));

            ListNode head = null;
            int count = 1;
            ListNode prev = null;
            for (ListNode node : nodes) {
                if (count == 1) {
                    head = node;
                    prev = node;
                    count++;
                    continue;
                }

                prev.next = node;
                prev = node;
                if (count == nodes.size()) {
                    node.next = null;
                }
                count++;
            }

            return head;
        }
}