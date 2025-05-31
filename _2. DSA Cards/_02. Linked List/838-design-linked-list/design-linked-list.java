class Node {
        public int val;
        public Node prev;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    class MyLinkedList {
        private Node head;
        private Node tail;
        int size;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index >= this.size || this.size == 0) {
                return -1;
            }

            Node node = this.head;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }

            if (node == null) {
                return 0;
            } else {
                return node.val;
            }

        }

        public void addAtHead(int val) {
            Node node = new Node(val);

            if (this.size == 0) {
                this.head = node;
                this.tail = node;
                this.size++;
                return;
            }

            Node oldHead = this.head;
            oldHead.prev = node;
            this.head = node;
            node.next = oldHead;
            this.size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);

            if (this.size == 0) {
                this.head = node;
                this.tail = node;
                this.size++;
                return;
            }

            Node oldTail = this.tail;
            oldTail.next = node;
            this.tail = node;
            node.prev = oldTail;
            this.size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > this.size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            if (index == this.size) {
                addAtTail(val);
                return;
            }

            Node node = new Node(val);
            Node prev = null;
            Node next = this.head;

            for (int i = 1; i <= index; i++) {
                next = next.next;
            }
            prev = next.prev;

            node.next = next;
            node.prev = prev;

            prev.next = node;
            next.prev = node;
            this.size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= this.size) {
                return;
            }

            if (index == 0) {
                Node delete = this.head;
                if (this.size == 1) {
                    this.head = null;
                    this.tail = null;
                    this.size--;
                    return;
                }
                Node newHead = delete.next;
                delete.next = null;
                newHead.prev = null;
                this.head = newHead;
                this.size--;
                return;
            }

            if (index == this.size - 1) {
                Node delete = this.tail;
                Node newTail = delete.prev;
                delete.prev = null;
                newTail.next = null;
                this.tail = newTail;
                this.size--;
                return;
            }

            Node delete = this.head;
            for (int i = 1; i <= index; i++) {
                delete = delete.next;
            }
            Node prev = delete.prev;
            Node next = delete.next;

            prev.next = next;
            next.prev = prev;
            delete.prev = null;
            delete.next = null;
            this.size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */