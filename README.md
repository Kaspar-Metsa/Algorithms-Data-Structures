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

## Trees
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

## Trees and Graphs

### General

#### Binary Tree BFS Level Order Traversal

- [Solution](src/main/java/treeGraphs/general_binaryTreeTraversal/LevelOrderTraversal_BFS.java)
  - Time O(n)
    - We visit each node once
    - We are doing enqueue O(1) and dequeue O(1) for each node = n*2*O(1)=O(n)
  - Space 2xO(n)=O(n)
    - We return a list with all nodes, at most n elements so **O(n)**
    - We are also storing nodes inside a queue which can contain at most **(#_of_nodes_in_bottom)=(
      n+1)/2** elements if queue is balanced, and we are on lowest level. This is **O(n)**

#### Binary Tree DFS In Order Traversal

- [Solution](src/main/java/treeGraphs/general_binaryTreeTraversal/InOrderTraversal_DFS.java)
- Useful for returning nodes in non-decreasing order in Binary Search Tree
- Variation for reverse: non-increasing order in Binary Search Tree
  - [Solution](src/main/java/treeGraphs/general_binaryTreeTraversal/InOrderTraversalReversed_DFS.java)

#### Binary Tree DFS Pre Order Traversal

- [Solution](src/main/java/treeGraphs/general_binaryTreeTraversal/PreOrderTraversal_DFS.java)
- Useful for
  - Copying the tree
  - Getting prefix expression of an expression tree

#### Binary Tree DFS Post Order Traversal

- [Solution](src/main/java/treeGraphs/general_binaryTreeTraversal/PostOrderTraversal_DFS.java)
- Useful for
  - Deleting the tree
  - Getting postfix expression of the expression tree

#### Binary Tree DFS Pre-Order, In-Order, Post-Order Traversal Complexity

- Time O(n)
  - 1st explanation(easy)
    - The amount of work we do for each node is constant
  - 2nd explanation(medium)
    - For a graph, DFS time complexity is O(n+m), n=number of nodes, m=number of edges
    - Binary tree is a graph where number of edges m originating from each node is 2
    - Total edges in binary tree is n-1
    - Time O(n)=O(n+m)=O(n+(n-1))=O(n)
  - 3rd explanation(hard)
    - Easy
      proof: https://www.baeldung.com/cs/tree-traversal-time-complexity#time-complexity-of-the-tree-traversals
    - Proof using Master's Theorem
      - https://stackoverflow.com/a/56799754
- Space
  - O(n) - size of the stack
    - In skewed tree O(n)=h=n
    - In balanced tree O(n)=h=log<sub>2</sub>(n+1)

### Binary Search Tree

- Questions
  - Are there duplicate values?
    - If answer is yes, it is automatically not a valid BST
- Test cases
  - True cases
    - One node
    - True case with depth 3 each side, 7 total nodes
  - False cases
    - 3 nodes: Where right child is smaller than root
    - 3 nodes: Where left child is larger than root
    - 7 nodes: Where left is smaller than root but left.right child is larger than root
    - 7 nodes: Where right is larger than root but right.left child is smaller than root

#### 235. Lowest Common Ancestor (Easy)

- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
- [DFS](src/main/java/treeGraphs/binary_search_tree/Q235_lowestCommonAncestor_bst/Q235_lowestCommonAncestor_DFS.java)
  - Time O(n)=O(height)
    - In skewed tree height=n
    - In balanced tree h=log<sub>2</sub>(n+1)
  - Space O(n)=O(height)
    - In skewed tree height=n
    - In balanced tree h=log<sub>2</sub>(n+1)
- [BFS](src/main/java/treeGraphs/binary_search_tree/Q235_lowestCommonAncestor_bst/Q235_lowestCommonAncestor_BFS.java)
  - Time O(n)=O(height)
    - In skewed tree height=n
    - In balanced tree h=log<sub>2</sub>(n+1)
  - Space O(1)

#### Q98 Validate Binary Search Tree (Medium)

- Questions
  - Can node value be equal to or greater than 2<sup>31</sup>-1
  - Can there be duplicates - if duplicates, BST is not valid

#### Naive

- Idea is to do take root value X and then check in each subtree if each element is smaller/larger
  than X
  - If it is, we go to one child left/right and do the same
- Time O(n2)
- To show an example where it's n2 and to show it can't be worse than n2
  - If nodes is n-1=4
  - The total number of times we visit a bottom leaf is **O(n2)**
    - (n-1)+(n-2)+(n-3)+(n-4)=((n-1)*(n-1+1))/2=(n2-n)/2=O(n2)
    - 4 +3 +2 +1 =4*(4+1)/2 =10
      - This is because root node has n-1 children, root.left has n-2 children
      - if 4 is root, 4 has 3 children, 4.left has 2 children etc
  - **TODO: Lets show it with recurrence relation**
- Space O(n)
  - Because we don't store node values anywhere, call stack can be as deep as the height of the tree
    - Height if skewed = n
    - Height if balanced = log<sub>2</sub>(n+1)

#### Limits

- Idea is to store the max/min a value can be in each branch
  - We use the idea that if root is X, then root.left.right.right.right...right must be smaller than
    X
- Max integer value int Java is 2 147 483 647 = 2<sup>31</sup>-1
- Max node value in input can also be 2 147 483 647 = 2<sup>31</sup>-1
  - That's why we **can't use int or Integer** to store max value because max value needs to larger
    than node.val
  - We have to use Long or BigInteger
    - because long max value is 9 223 372 036 854 775 808=2<sup>63</sup>-1
- Time O(n)
  - Because we traverse each node once
- Space O(n)
  - Because we don't store node values anywhere, call stack can be as deep as the height of the tree
    - Height if skewed = n
    - Height if balanced = log<sub>2</sub>(n+1)

#### Inorder

- Idea is to do regular inorder traversal on BST which traverses node values in non-decreasing order
  and store values in a list, then check if list is sorted
  - If list is sorted, we have a valid BST
- Time O(n)
  - Because we traverse each node once
- Space 2xO(n)=O(n)
  - The list is O(n) because it contains all nodes
  - The call stack is height
    - Height if skewed = n
    - Height if balanced = log<sub>2</sub>(n+1)

#### Inorder Optimized

- Idea is to do regular inorder traversal on BST which traverses node values in non-decreasing order
  and not store values in a list, but instead just compare with previously traversed value
  - If previously traversed value is smaller, we have a valid BST
- Time O(n)
  - Because we traverse each node once
- Space O(n)
  - There is no list
  - The call stack is height
    - Height if skewed = n
    - Height if balanced = log<sub>2</sub>(n+1)

### Binary Tree BFS & DFS

#### Q102 Level Order Binary Tree BFS Traversal

- https://leetcode.com/problems/binary-tree-level-order-traversal/
  - [Solution](src/main/java/treeGraphs/Q102_binaryTreeLevelOrderTraversal/Q102_binaryTreeLevelOrderTraversal_BFS.java)
    - Time O(n)
      - We visit each node once
      - We are doing enqueue O(1) and dequeue O(1) for each node = **2nxO(1)=O(n)**
    - Space 2xO(n) because double list + O(n) for queue if balanced tree = O(n)
      - We store a list of (list for each level). There can be n such lists if skewed tree. This
        is **O(n)**
      - We are also storing nodes inside a queue which can contain at most **(#_of_nodes_in_bottom)
        =(n+1)/2** elements if queue is balanced, and we are on lowest level. This is **O(n)**

#### Q111 Minimum Depth of Binary Tree
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
#### 104. Maximum Depth of Binary Tree
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
    - Total if balanced tree: **O(n)+2xO((n+1)/2) = O(n)**
- [DFS](src/main/java/treeGraphs/Q103_binaryTreeZigzagLevelOrderTraversal/Q103_binaryTreeZigzagLevelOrderTraversal_DFS.java)
  - Time O(n)
    - We visit each node once
  - Space O(n)
    - In a skewed tree recursion stack is O(n)
    - List<List<Integer>> (for answer) can contain n elements in skewed tree
    - List<Integer> currentLevelList can contain (n+1)/2 elements in bottom level if balanced tree

#### 199. Right side view

- https://leetcode.com/problems/binary-tree-right-side-view/
- [BFS](src/main/java/treeGraphs/Q199_rightSideView/Q199_rightSideView_BFS.java)
  - Time O(n)
    - Because we visit every node
  - Space O(n)=O(L) where L is the maximum number of nodes in a level=(n+1)/2
- [DFS](src/main/java/treeGraphs/Q199_rightSideView/Q199_rightSideView_DFS.java)
  - Time O(n)
    - Because we visit every node
  - Space O(n)= O(height of the tree) for storing the call stack, in worst case with skewed tree h=n
- Space complexity is better for
  - BFS if tree is very deep but not wide because in this case DFS's space complexity is O(n)
    because n=height but BFS's space complexity is O((n+1/2))
  - DFS if tree is very wide but not deep bec

### Graphs

#### 200. Number of Islands (Medium)

- https://leetcode.com/problems/number-of-islands/
- Questions to ourselves
  - Does the order of traversal matter?
    - No
  - How to avoid double counting?
    - By modifying the input grid


- [DFS](src/main/java/treeGraphs/Q200_numberOfIslands/Q200_numberOfIslands_DFS.java)
  - Time
    - O(MxNx2)=O(MxN) where M is rows(outside array) and N is columns(inside array) = O(n) where
      n=elements in grid
      - Because in worst case where all elements are 1, then we do one large DFS into all directions and turn all 1-s into 0-s, but then we still iterate through all elements again.
  - Space
    - O(MxN) where M is rows(outside array) and N is columns(inside array)
      - Because in worst case where all elements are 1, our recursion stack is going to MxN deep

- [BFS](src/main/java/treeGraphs/Q200_numberOfIslands/Q200_numberOfIslands_BFS.java)
  - Time
    - O(MxNx2)=O(MxN) where M is rows(outside array) and N is columns(inside array) = O(n) where n=elements in grid
      - Because in worst case where all elements are 1, then we do one large DFS into all directions and turn all 1-s into 0-s, but then we still iterate through all elements again.
  - Space
    - O(min(MxN)) where M is rows(outside array) and N is columns(inside array).
      - Because even in worst where all elements are 1, we will not be adding all these elements to our queue at the same time 