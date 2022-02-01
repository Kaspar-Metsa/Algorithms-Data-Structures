# Leetcode patterns using TDD

## Two pointer technique
### 1. Same Direction
### 2. Opposite Direction
### 3. Sliding Window
- https://leetcode.com/problems/longest-substring-without-repeating-characters/
  - [Optimal](src/main/java/arraysStrings/slidingWindow/Q3_longestSubstringWithoutRepeatingCharacters/Solution.java)
    - Time O(n) Space O(n)
### 4. Non-array application
## Palindrome

## Trees and Graphs
### Formulas
![Alt text](src/main/resources/Complete_Tree.jpg?raw=true "Complete Tree")
- Example complete tree
  - n=7, h=3
#### #_of_nodes in perfect binary tree(from height)
  - 2^(height)-1 
  - 2^(3)-1=7
#### #_of_nodes_except_bottom(from height)
- 2^(height-1)-1
  - 2^(3-1)-1=3
#### #_of_nodes_in_bottom(from height)
- 2^(height-1)
  - 2^(3-1)=4
#### #_of_nodes_in_bottom(from #_of_all_nodes)
- (n+1)/2
  - (7+1)/2
#### #_of_nodes_in_bottom(from #_of_nodes_in_other_levels)
- sum(#_of_nodes_except_bottom)+1
#### Height of perfect binary tree(from #_of_all_nodes)
- log(#_of_all_nodes +1)
- log(7+1)=3
#### Height of perfect binary tree(from #_of_nodes_in_bottom)
#### Height of the tree(from #_of_nodes_in_bottom)
- log(#_of_nodes_in_bottom)+1
#### Height of the tree(from n)
- log(n)
  - log(4)+1=3

### BFS
#### General Binary Tree BFS Traversal
- [Solution](src/main/java/treeGraphs/general_binaryTreeTraversal/general_binaryTreeTraversal_BFS.java)
  - Time O(n)
    - We are doing enqueue O(1) and dequeue O(1) for each node = 2n*O(1)=O(n)
  - Space 2xO(n)=O(n)
    - We return a list with all node values, at most n elements so O(n)
    - We are also storing nodes inside a queue which can contain at most O(2^h) elements if queue is balanced, and we are on lowest level. For a balanced tree, h = logn and required size of the queue = O(2^h) = O(2 ^ (log n)) = O(n).
#### Level Order Binary Tree BFS Traversal
- https://leetcode.com/problems/binary-tree-level-order-traversal/
  - [Solution](src/main/java/treeGraphs/Q102_binaryTreeLevelOrderTraversal/Q102_binaryTreeLevelOrderTraversal_BFS.java)
    - Time O(n)
      - We are doing enqueue O(1) and dequeue O(1) for each node = 2n*O(1)=O(n)
    - Space 2xO(n) because double list + O(n) for queue if balanced tree = O(n)
      - We return a list with all nodes in a level, this list can contain at most O(2^h) elements if queue is balanced, and we are on lowest level. For a balanced tree, h = logn and required size of the list = O(2^h) = O(2 ^ (log n)) = O(n).
      - We are also storing a list of list of levels. There can be n such lists if linkedlist. So we could be storing double list for every node so 2*O(n)
      - We are also storing nodes inside a queue which can contain at most O(2^h) elements if queue is balanced, and we are on lowest level. For a balanced tree, h = logn and required size of the queue = O(2^h) = O(2 ^ (log n)) = O(n).
      - Best case is if every level has 1 element, essentially a linkedlist, then space complexity O(1)
#### Minimum Depth of Binary Tree
- https://leetcode.com/problems/minimum-depth-of-binary-tree/
  - [BFS](src/main/java/treeGraphs/Q111_minDepthOfBinaryTree/Q111_minDepthOfBinaryTree_BFS.java)
    - Time O(n)
      - We are doing enqueue O(1) and dequeue O(1) for each node = 2n*O(1)=O(n)
    - Space O(n) if balanced tree
      - We are storing nodes inside a queue which can contain at most O(2^(h-1)) elements if queue is balanced, and we are on lowest-1 level, because on lowest level we already return. For a balanced tree, h = logn and required size of the queue = O(2^h) = O(2 ^ (log n)) = O(n).
  - [DFS](src/main/java/treeGraphs/Q111_minDepthOfBinaryTree/Q111_minDepthOfBinaryTree_DFS.java)
  - [DFS short](src/main/java/treeGraphs/Q111_minDepthOfBinaryTree/Q111_minDepthOfBinaryTree_DFSShort.java)
    - Time O(n)
      - We visit each node
      - There could be an optimization where once we find the minimum in left subtree then we don't need to look past it in right subtree, doesn't affect time complexity, only useful if we know that left subtree is likely to contain answer
    - Space O(n)
      - Because worst is if all nodes have left child only, then call stack is n levels deep
      - Best case is completely balanced tree, then call stack is O(h)=O(logN) deep
#### Maximum Depth of Binary Tree
- https://leetcode.com/problems/maximum-depth-of-binary-tree/
- [DFS](src/main/java/treeGraphs/Q104_maxDepthOfBinaryTree/Q104_maxDepthOfBinaryTree_DFSRecursive.java)
  - Time O(n)
    - We visit each node
  - Space O(n)
    - If skewed tree, the size of our recursion stacks is the number of nodes.
    - In a perfectly balanced tree space would be the height of the tree = O(logn)
- [BFS](src/main/java/treeGraphs/Q104_maxDepthOfBinaryTree/Q104_maxDepthOfBinaryTree_BFS.java)
  - Time O(n)
    - We visit each node
  - Space O(n)
    - Queue of the lowest level can reach O(n)