/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
     public Node insert(Node head, int insertVal) {
            Node insert = new Node(insertVal);
            if (head == null) {
                insert.next = insert;
                return insert;
            }

            if (head.next == null) {
                head.next = insert;
                insert.next = head;
                return head;
            }

            Node current = head;
            Node next = current.next;
            while (true) {
                if ((current.val <= insertVal && insertVal <= next.val) ||
                        (current.val > next.val && insertVal >= current.val) ||
                        (current.val > next.val && insertVal < next.val) ||
                        (current.val == next.val && next.equals(head)) ||
                        (current.val < next.val && next.equals(head))) {
                    current.next = insert;
                    insert.next = next;
                    return head;
                }

                current = current.next;
                next = current.next;
            }
        }
}