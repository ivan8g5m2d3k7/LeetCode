class Solution {

        class TrieNode {
            private TrieNode[] array = new TrieNode[2];

            public TrieNode() {

            }
        }

        public int findMaximumXOR(int[] nums) {
            int maxNum = Arrays.stream(nums).max().getAsInt();
            int bitCount = Integer.toBinaryString(maxNum).length();
            int maxXor = 0;
            TrieNode root = new TrieNode();

            for (int num : nums) {
                TrieNode current = root;
                TrieNode xorNode = root;
                int currentXor = 0;

                for (int i = bitCount - 1; i >= 0; i--) {
                    int bit = (num >> i) & 1;
                    int toggledBit = bit ^ 1;

                    if (current.array[bit] == null) {
                        current.array[bit] = new TrieNode();
                    }
                    current = current.array[bit];

                    if (xorNode.array[toggledBit] != null) {
                        currentXor |= (1 << i);
                        xorNode = xorNode.array[toggledBit];
                    } else {
                        xorNode = xorNode.array[bit];
                    }
                }
                
                maxXor = Math.max(maxXor, currentXor);
            }
            
            return maxXor;
        }
    }