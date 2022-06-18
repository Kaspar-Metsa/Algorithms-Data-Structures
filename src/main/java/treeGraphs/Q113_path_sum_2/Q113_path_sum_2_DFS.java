package treeGraphs.Q113_path_sum_2;

import java.util.ArrayList;
import java.util.List;

import treeGraphs.util.TreeNode;

/*
    Why LinkedList better here???? Maybe because of array resizing when adding?
    is removing the last element O(1) in both LinkedList and ArrayList

    Time:
    Copying ArrayList or LinkedList is O(n)

    O(n2). In worst case we have complete binary tree. Complete binary tree has this number of leaves: (n+1)/2.
    For every leaf, we perform a potential O(n) operations of copying over the nodes to a new list, that is later added to answer.

    Space:
    Extra Space (without counting output as space): O(H), where H is height of the binary tree. This is the space for stack recursion or keeping path so far.

*/

public class Q113_path_sum_2_DFS {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        pathSum(root, sum, curPath, ans);
        return ans;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> curPath, List<List<Integer>> ans) {
        if (root == null) return;
        curPath.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            ans.add(new ArrayList<>(curPath)); //We might reach this point O(n) times and this operation takes O(n) time
            curPath.remove(curPath.size() - 1);
            return;
        } else {
            pathSum(root.left, sum - root.val, curPath, ans);
            pathSum(root.right, sum - root.val, curPath, ans);
        }
        curPath.remove(curPath.size() - 1);
    }
}


/*

class Solution {
    public:
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        vector<vector<int>> list;

        // Input validation.
        if (root == NULL) return list;

        vector<int> subList;
        int tmp_sum = 0;

        helper(root, sum, tmp_sum, list, subList);

        return list;
    }

    void helper(TreeNode *root, int sum, int tmp_sum,
                vector<vector<int>> &list, vector<int> &subList) {

        // Base case.
        if (root == NULL) return;
        if (root->left == NULL && root->right == NULL) {
            // Have a try.
            tmp_sum += root->val;
            subList.push_back(root->val);

            if (tmp_sum == sum) {
                vector<int> one_result(subList);
                list.push_back(one_result);
            }

            // Roll back.
            tmp_sum -= root->val;
            subList.pop_back();

            return;
        }

        // Have a try.
        tmp_sum += root->val;
        subList.push_back(root->val);

        // Do recursion.
        helper(root->left, sum, tmp_sum, list, subList);
        helper(root->right, sum, tmp_sum, list, subList);

        // Roll back.
        tmp_sum -= root->val;
        subList.pop_back();
    }
};

 */