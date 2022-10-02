package trees.Q543_diameterOfBinaryTree;

import java.util.ArrayDeque;
import java.util.HashMap;

import trees.util.TreeNode;

public class Q543_diameterOfBinaryTree_BFS {


/*
 Better solution because below one keeps all nodes in hashmap, we only need to remember 2 previous ones
*/

    public int diameterOfBinaryTree(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode lastNodeVisited = null;
        TreeNode curr = root;
        int d = 0;
        HashMap<TreeNode, Integer> nodeVsheight = new HashMap<>();

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode x = stack.peek();
                if (x.right != null && x.right != lastNodeVisited) {
                    curr = x.right;
                } else {
                    // Since post order we have already calculated height of left and right tree
                    int lH = x.left != null ? nodeVsheight.remove(x.left) : 0;
                    int rH = x.right != null ? nodeVsheight.remove(x.right) : 0;

                    d = Math.max(d, lH + rH);

                    int xH = 1 + Math.max(lH, rH);
                    nodeVsheight.put(x, xH);

                    stack.pop();
                    lastNodeVisited = x;
                }
            }
        }
        return d;
    }
    //curr=null
    //stack=5,2,1
    //lastNodeVisited=4

    //x=5
    //lH=0
    //rH=0
    //d=0
    //xH=1
    //nodeVsheight={4:1}

    /*
             1
           /  \
          2   3
         / \
        4  5
    */


    /*
    "The idea is to use Post order traversal which means make sure the node is there till the left and
    right children are processed that's the reason you use peek method in the stack to not pop it off
    without being done with the left and right child nodes. Then for each node calculate the max of the left
    and right subtrees depth and also simultaneously calculate the overall max of the left and right subtrees count."
*/
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//        int ansMax = 0;
//        Deque<TreeNode> nodeStack = new ArrayDeque<>();
//        Map<TreeNode, Integer> nodePathCountMap = new HashMap<>();
//        nodePathCountMap.clear();
//        List<Integer> traversalOrder = new ArrayList<>();
//        nodeStack.push(root);
//        while (!nodeStack.isEmpty()) {
//            TreeNode node = nodeStack.peek();
//            if (node.left != null && !nodePathCountMap.containsKey(node.left)) {
//                nodeStack.push(node.left);
//            } else if (node.right != null && !nodePathCountMap.containsKey(node.right)) {
//                nodeStack.push(node.right);
//            } else {
//                TreeNode rootNodeEndOfPostOrder = nodeStack.pop();
//                int leftMax = nodePathCountMap.getOrDefault(rootNodeEndOfPostOrder.left, 0);
//                int rightMax = nodePathCountMap.getOrDefault(rootNodeEndOfPostOrder.right, 0);
//                int nodeMax = 1 + Math.max(leftMax, rightMax);
//                nodePathCountMap.put(rootNodeEndOfPostOrder, nodeMax);
//                ansMax = Math.max(ansMax, leftMax + rightMax);
//                traversalOrder.add(rootNodeEndOfPostOrder.val);
//            }
//        }
//        System.out.println(traversalOrder);
//        return ansMax;
//    }
}
    /*
             1
           /  \
          2   3
         / \
        4  5
        root=1
        ansMax=0
        nodeStack=2,1
        nodePathCountMap={4:1, 5:1, }
        node=2
        rootNodeEndOfPostOrder=2
        leftMax=0
        rightMax=0
        nodeMax=1
    */