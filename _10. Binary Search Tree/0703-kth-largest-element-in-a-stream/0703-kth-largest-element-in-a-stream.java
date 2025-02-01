class KthLargest {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public int count;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
            count = 1;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
            count = 1;
        }
    }

            private Node root;
            private int k;

            public KthLargest(int k, int[] nums) {
                for (int num : nums) {
                    this.root = insert(this.root, num);
                }
                this.k = k;
            }

            public int add(int val) {
                this.root = insert(this.root, val);
                return findKthLargest(this.root, this.k);
            }

            public Node insert(Node node, int val) {
                if (node == null) {
                    return new Node(val);
                }

                if (val < node.val) {
                    node.left = insert(node.left, val);
                } else {
                    node.right = insert(node.right, val);
                }

                node.count++;
                return node;
            }

            public int findKthLargest(Node node, int k) {
                if (node == null) {
                    return -1;
                }
                
                int rightCount = 0;
                if (node.right != null) {
                    rightCount = node.right.count;
                }

                if (k == rightCount + 1) {
                    return node.val;
                } else if (k <= rightCount) {
                    return findKthLargest(node.right, k);
                } else { // k > node.right.count
                    return findKthLargest(node.left, k - rightCount - 1);
                }
            }
        }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */