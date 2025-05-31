/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
            if (head == null || head.next == null && head.child == null) {
                return head;
            }
            Node current = head;

            while (current != null) {
                if (current.child != null) {
                    makeFlat(current);
                }

                current = current.next;
            }

            return head;
        }

        private void makeFlat(Node node) {
            while (node != null) {
                if (node.child != null) {
                    Node next = node.next;
                    Node start = node.child;
                    Node end = start;
                    node.child = null;
                    if (start.child != null) {
                        makeFlat(start);
                    }

                    while (end.next != null) {
                        end = end.next;
                        if (end.child != null) {
                            makeFlat(end);
                        }
                    }

                    node.next = start;
                    start.prev = node;
                    end.next = next;
                    
                    if (next != null) {
                        next.prev = end;
                    }
                }

                node = node.next;
            }
        }
}