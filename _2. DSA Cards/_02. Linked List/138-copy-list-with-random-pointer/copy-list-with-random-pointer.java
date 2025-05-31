/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
            Map<Node, Node> oldToNew = new HashMap<>();
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                Node result = new Node(head.val);
                if (head.random != null) {
                    result.random = result;
                }
                return result;
            }

            Node current = head;
            Node newHead = null;
            while (current != null) {
                Node node = oldToNew.getOrDefault(current, new Node(current.val));

                if (current.next != null) {
                    Node next = oldToNew.getOrDefault(current.next, new Node(current.next.val));
                    oldToNew.putIfAbsent(current.next, next);
                    node.next = next;
                }
                if (current.random != null) {
                    Node random = oldToNew.getOrDefault(current.random, new Node(current.random.val));
                    oldToNew.putIfAbsent(current.random, random);
                    node.random = random;
                }
                
                oldToNew.putIfAbsent(current, node);
                if (current.equals(head)) {
                    newHead = node;
                }
                
                current = current.next;
            }
            
            return newHead;
        }
}