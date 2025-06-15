class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new ArrayDeque<>();
            Deque<Integer> stack2 = new ArrayDeque<>();
            Deque<Integer> stack3 = new ArrayDeque<>();

            ListNode curr = l1;
            while (curr != null) {
                stack1.push(curr.val);
                curr = curr.next;
            }
            curr = l2;
            while (curr != null) {
                stack2.push(curr.val);
                curr = curr.next;
            }

            int carry = 0;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
                int sum = carry;
                if (!stack1.isEmpty()) {
                    sum += stack1.pop();
                }
                if (!stack2.isEmpty()) {
                    sum += stack2.pop();
                }

                if (sum <= 9) {
                    carry = 0;
                } else {
                    carry = 1;
                    sum = sum - 10;
                }

                stack3.push(sum);
            }

            ListNode dummy = new ListNode();
            curr = dummy;
            while (!stack3.isEmpty()) {
                curr.next = new ListNode(stack3.pop());
                curr = curr.next;
            }

            return dummy.next;
        }
    }