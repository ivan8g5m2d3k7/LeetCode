/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> nodesA = new HashSet<>();
            ListNode currentA = headA;
            while (currentA != null) {
                nodesA.add(currentA);
                currentA = currentA.next;
            }
            
            ListNode currentB = headB;
            while (currentB != null) {
                if (nodesA.contains(currentB)) {
                    return currentB;
                }
                currentB = currentB.next;
            }
            
            return null;
        }
}