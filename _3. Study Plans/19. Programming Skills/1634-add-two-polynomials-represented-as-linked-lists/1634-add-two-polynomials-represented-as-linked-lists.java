class Solution {
        public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
            PriorityQueue<PolyNode> maxHeap =
                    new PriorityQueue<>(Comparator.comparingInt( (PolyNode p) -> p.power).reversed());
            while (poly1 != null) {
                maxHeap.offer(poly1);
                poly1 = poly1.next;
            }
            while (poly2 != null) {
                maxHeap.offer(poly2);
                poly2 = poly2.next;
            }

            PolyNode dummy = new PolyNode();
            PolyNode prev = dummy;
            while (!maxHeap.isEmpty()) {
                PolyNode curr = maxHeap.poll();
                int c = curr.coefficient;
                int p = curr.power;
                if (maxHeap.peek() != null && maxHeap.peek().power == p) {
                    PolyNode next = maxHeap.poll();
                    c += next.coefficient;
                    if (c == 0) {
                        continue;
                    }
                }
                
                PolyNode node = new PolyNode(c, p);
                prev.next = node;
                prev = node;
            }
            
            return dummy.next;
        }
    }