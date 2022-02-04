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
### Logarithm formulas
#### a<sup>log<sub>a</sub>X</sup>=X
#### logA−logB = log(A/B)
### Tree Formulas
![Alt text](src/main/resources/Complete_Tree.jpg?raw=true "Complete Tree")
- Example perfect binary tree
  - n=7, h=3
#### #_of_nodes in perfect binary tree(from height)
  - **n=2<sup>h</sup>-1**
    - **IMPORTANT**
  - n=2<sup>3</sup>-1=7
#### Height of the tree(from n)
- **h=log<sub>2</sub>(n+1)**
  - **IMPORTANT**
  - Because n+1=2<sup>h</sup> -> n=2<sup>h</sup>-1
- h=log<sub>2</sub>(7+1)=3
#### #_of_nodes_in_bottom(from #_of_all_nodes)
- **(#_of_nodes_in_bottom)=(n+1)/2**
  - **IMPORTANT**
- (#_of_nodes_in_bottom)=(7+1)/2=4
#### #_of_nodes_in_bottom(from height)
- **2<sup>h-1</sup>**
  - **IMPORTANT**
  - Because 2<sup>(log<sub>2</sub>n+1)-1</sup>=2<sup>(log<sub>2</sub>n+1)-log<sub>2</sub>2</sup>=2<sup>(log<sub>2</sub>(n+1)/2)</sup>=2<sup>(log<sub>2</sub>(n+1)/2)</sup>=(n+1)/2
- 2<sup>3-1</sup>=4
#### #_of_nodes_in_bottom(from #_of_nodes_in_other_levels)
- (#_of_nodes_in_other_levels)+1
- 3+1=4
#### #_of_nodes_except_bottom(from height)
- 2<sup>h-1</sup>-1
- 2<sup>3-1</sup>-1=3
#### #_of_nodes_except_bottom(from n)
- n - (n+1)/2
#### #_of_nodes_in_next_to_bottom_level(from n)
- (n+1)/4
  - Because 
    - (#_of_bottom_nodes)=(n+1)/2
    - (#_of_nodes_except_bottom)=n-(n+1)/2
    - (x+1)/2 x=n-(n+1)/2 (n-(n+1)/2+1)/2=((2n-n-1+2)/2)/2=((n+1)/2)/2=(n+1)*1/4=(n+1)/4
#### Height of the tree(from #_of_nodes_in_bottom)
- log<sub>2</sub>(#_of_nodes_in_bottom)+1
#### Height of perfect binary tree(from #_of_nodes_in_bottom)

### BFS
#### General Binary Tree BFS Traversal
- [Solution](src/main/java/treeGraphs/general_binaryTreeTraversal/general_binaryTreeTraversal_BFS.java)
  - Time O(n)
    - We visit each node once
    - We are doing enqueue O(1) and dequeue O(1) for each node = 2n*O(1)=O(n)
  - Space 2xO(n)=O(n)
    - We return a list with all nodes, at most n elements so **O(n)**
    - We are also storing nodes inside a queue which can contain at most **(#_of_nodes_in_bottom)=(n+1)/2** elements if queue is balanced, and we are on lowest level. This is **O(n)**
#### Level Order Binary Tree BFS Traversal
- https://leetcode.com/problems/binary-tree-level-order-traversal/
  - [Solution](src/main/java/treeGraphs/Q102_binaryTreeLevelOrderTraversal/Q102_binaryTreeLevelOrderTraversal_BFS.java)
    - Time O(n)
      - We visit each node once
      - We are doing enqueue O(1) and dequeue O(1) for each node = **2nxO(1)=O(n)**
    - Space 2xO(n) because double list + O(n) for queue if balanced tree = O(n)
      - We store a list of (list for each level). There can be n such lists if skewed tree. This is **O(n)**
      - We are also storing nodes inside a queue which can contain at most **(#_of_nodes_in_bottom)=(n+1)/2** elements if queue is balanced, and we are on lowest level. This is **O(n)**
#### Minimum Depth of Binary Tree
- https://leetcode.com/problems/minimum-depth-of-binary-tree/
  - [BFS](src/main/java/treeGraphs/Q111_minDepthOfBinaryTree/Q111_minDepthOfBinaryTree_BFS.java)
    - Time O(n)
      - We visit each node once
      - We are doing enqueue O(1) and dequeue O(1) for each node = **2nxO(1)=O(n)**
    - Space O(n) if balanced tree
      - We are storing nodes inside a queue which can contain at most **(#_of_nodes_in_bottom_minus_1)=(x+1)/2 x=n-(n+1)/2 (#_of_nodes_in_bottom_minus_1)=(n-(n+1)/2+1)/2** elements if queue is balanced, and we are on lowest-1 level, because on lowest level we already return.
  - [DFS](src/main/java/treeGraphs/Q111_minDepthOfBinaryTree/Q111_minDepthOfBinaryTree_DFS.java)
  - [DFS short](src/main/java/treeGraphs/Q111_minDepthOfBinaryTree/Q111_minDepthOfBinaryTree_DFSShort.java)
    - Time O(n)
      - We visit each node once
      - There could be an optimization where once we find the minimum in left subtree then we don't need to look past it in right subtree, doesn't affect time complexity, only useful if we know that left subtree is likely to contain answer.
        - **How???**
    - Space O(n)
      - Worst case if skewed, then call stack is n levels deep
      - Best case is completely balanced tree, then call stack is O(h)=O(log(n+1)) deep
#### Maximum Depth of Binary Tree
- https://leetcode.com/problems/maximum-depth-of-binary-tree/
- [DFS recursive](src/main/java/treeGraphs/Q104_maxDepthOfBinaryTree/Q104_maxDepthOfBinaryTree_DFSRecursive.java)
  - Time O(n)
    - We visit each node once
  - Space O(n)
    - If skewed tree, the size of our recursion stacks is **O(n)**
    - In a perfectly balanced tree stack size(and thus the space) would be the height of the tree **O(h)=O(log(n+1))**
- [DFS iterative](src/main/java/treeGraphs/Q104_maxDepthOfBinaryTree/Q104_maxDepthOfBinaryTree_DFSIterative.java)
  - Time O(n)
    - We visit each node once
  - Space O(n)
    - If skewed tree, the size of both stacks is **O(n)**
    - In a perfectly balanced tree stack size(and thus the space) would be the height of the tree **O(h)=O(log(n+1))**
- [BFS](src/main/java/treeGraphs/Q104_maxDepthOfBinaryTree/Q104_maxDepthOfBinaryTree_BFS.java)
  - Time O(n)
    - We visit each node once
  - Space O(n)
    - Queue of the lowest level can reach O(n) because lowest level can contain **(#_of_nodes_in_bottom)=(n+1)/2**
#### 103. Binary Tree Zigzag Level Order Traversal
- https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
- [BFS](src/main/java/treeGraphs/Q103_binaryTreeZigzagLevelOrderTraversal/Q103_binaryTreeZigzagLevelOrderTraversal_BFS.java)
  - Time O(n)
    - We visit each node once
  - Space O(n)
    - We have 3 collections: List of all levels, level list, queue
    - List of all levels can contain **n** lists if skewed tree
    - Level list can contain at most **(n+1)/2** elements if balanced tree
    - queue can contain at most **(n+1)/2** elements if balanced tree
    - Total if balanced tree: **2xO(n)+O(log(n+1)) = O(n)**