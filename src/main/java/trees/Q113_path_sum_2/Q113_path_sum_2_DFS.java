package trees.Q113_path_sum_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import trees.util.TreeNode;

/*

https://docs.google.com/document/d/1mMo-0Glidk3MI3jtHOdrHsbfqaI45MAQ9FQHeysljRU/edit#

Idea:
    Pattern: preorder traversal with backtracking. Backtracking comes in when we remove the node from curPath after child is processed,
    so that when we switch to another branch, the node will not be double counted.

    We use LinkedList over ArrayList because:
        1. to avoid ArrayList resizing when adding elements.
        2. removing last element in LinkedList is O(1), in ArrayList it is O(n) if we don't have a reference

    We can't use BFS because BFS moves down one level at a time and that would mean we would have to keep all paths in memory at the same time.
        If complete binary tree we need to keep n+1/2 times log(n) length paths in memory = O(nlogn) space
        If half-linear-half-complete-tree we need to keep n/2 times n/2 length paths in memory = O(n2) space
    The benefit of DFS preorder is that we only need to keep one path in memory thanks to backtracking removing nodes from explored paths.

Time:
    Making a copy of ArrayList or LinkedList is O(n). Time taken is path length to copy x number of paths to copy

    With complete binary tree:
    Number of leaves: O((n+1)/2)
    Length of each path: O(logn)
    Time complexity: O(nlogn)

    Worst case if the top half of the tree is a linear tree, and the bottom half is a complete binary tree:
    1-1-1-1
    |
    1-1-1-1-1
           / \
          1   1
        / \  /  \
       1  1  1  1
   Number of leaves=number of paths= ((n/2)+1)/2 = n/4 (because we need to subtract n/2 from n) = O(n)
   length of each path = n/2+log(n/2) = O(n)
   Time complexity O(n) x O(n) = O(n2)
   https://leetcode.com/problems/path-sum-ii/discuss/1382469/Python-dfs-solution-with-complexity-explained

Space:
    Without considering space occupied by output we will not consider all the new lists created when we find a correct path.
    In that case space is O(H), where H is height of the binary tree. This is the space for stack recursion and curPath can be O(n) if skewed tree.
    If we consider output as space it is O(n2) because output can contain max number of paths x max length of each path(see Time complexity) = O(n2)

*/

public class Q113_path_sum_2_DFS {

    List<List<Integer>> pathSum(TreeNode node, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> curPath = new LinkedList<>();
        traverse(node, targetSum, ans, curPath);
        return ans;
    }

    void traverse(TreeNode node, int targetSum, List<List<Integer>> ans, LinkedList<Integer> curPath) {
        if (node == null) return;
        curPath.add(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            ans.add(new LinkedList<>(curPath));
        }
        traverse(node.left, targetSum - node.val, ans, curPath);
        traverse(node.right, targetSum - node.val, ans, curPath);
        curPath.removeLast();
    }

//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        List<List<Integer>> ans = new LinkedList<>();
//        List<Integer> curPath = new LinkedList<>();
//        pathSum(root, targetSum, curPath, ans);
//        return ans;
//    }
//
//    public void pathSum(TreeNode node, int targetSum, List<Integer> curPath, List<List<Integer>> ans) {
//        if (node == null) return;
//        curPath.add(node.val);
//        if (node.left == null && node.right == null && targetSum == node.val) {
//            ans.add(new LinkedList<>(curPath)); //We might reach this point O(n) times if balanced tree and pathSums=targetSum and this operation takes O(n) time
////            curPath.remove(curPath.size() - 1); //Unnecessary optimization
////            return; //Unnecessary optimization
//        }
//        pathSum(node.left, targetSum - node.val, curPath, ans);
//        pathSum(node.right, targetSum - node.val, curPath, ans);
//
//        curPath.remove(curPath.size() - 1);
//    }
}