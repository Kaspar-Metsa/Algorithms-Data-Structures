# Leetcode patterns using TDD

## Two pointer technique
### 1. Same Direction
### 2. Opposite Direction
### 3. Sliding Window
- https://leetcode.com/problems/longest-substring-without-repeating-characters/
  - [Optimal](application/src/main/java/arraysStrings/slidingWindow/Q3_longestSubstringWithoutRepeatingCharacters/Solution.java)
    - Time O(n) Space O(n)
### 4. Non-array application
## Palindrome

## Trees and Graphs
### BFS
#### General Binary Tree BFS Traversal
- [Solution](application/src/main/java/treeGraphs/bfs/general_binaryTreeBFSTraversal/Solution.java)
- Time O(n)
  - We are doing enqueue O(1) and dequeue O(1) for each node = 2n*O(1)=O(n)
- Space 2xO(n)=O(n)
  - We return a list with all node values, at most n elements so O(n)
  - We are also storing nodes inside a queue which can contain at most O(2^h) elements if queue is balanced, and we are on lowest level. For a balanced tree, h = logn and required size of the queue = O(2^h) = O(2 ^ (log n)) = O(n).
#### Level Order Binary Tree BFS Traversal
- https://leetcode.com/problems/binary-tree-level-order-traversal/
  - [Solution](application/src/main/java/treeGraphs/bfs/Q102_binaryTreeLevelOrderTraversal/Solution.java)
  - Time O(n)
    - We are doing enqueue O(1) and dequeue O(1) for each node = 2n*O(1)=O(n)
  - Space 2xO(n) because double list + O(n) for queue if balanced tree = O(n)
    - We return a list with all nodes in a level, this list can contain at most O(2^h) elements if queue is balanced, and we are on lowest level. For a balanced tree, h = logn and required size of the list = O(2^h) = O(2 ^ (log n)) = O(n).
    - We are also storing a list of list of levels. There can be n such lists if linkedlist. So we could be storing double list for every node so 2*O(n)
    - We are also storing nodes inside a queue which can contain at most O(2^h) elements if queue is balanced, and we are on lowest level. For a balanced tree, h = logn and required size of the queue = O(2^h) = O(2 ^ (log n)) = O(n).
    - Best case is if every level has 1 element, essentially a linkedlist, then space complexity O(1)