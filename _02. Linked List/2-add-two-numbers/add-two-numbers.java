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
import java.math.*;

class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder sb1 = new StringBuilder();
            ListNode i = l1;
            StringBuilder sb2 = new StringBuilder();
            ListNode j = l2;
            while (i != null) {
                sb1.append(i.val);
                i = i.next;
            }
            while (j != null) {
                sb2.append(j.val);
                j = j.next;
            }
            sb1.reverse();
            sb2.reverse();

            BigInteger num1 = new BigInteger(sb1.toString());
            BigInteger num2 = new BigInteger(sb2.toString());
            BigInteger sum = num1.add(num2);
            StringBuilder result = new StringBuilder(sum.toString()).reverse();

            ListNode head = new ListNode(Integer.parseInt(String.valueOf(result.charAt(0))));
            ListNode current = head;

            for (int k = 1; k < result.length(); k++) {
                ListNode node = new ListNode(Integer.parseInt(String.valueOf(result.charAt(k))));
                current.next = node;
                current = node;
            }

            return head;
        }
}