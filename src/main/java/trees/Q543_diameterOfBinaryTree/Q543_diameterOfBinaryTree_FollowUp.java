package trees.Q543_diameterOfBinaryTree;

/*
    Follow-up: print the path of the diameter
    NOT CORRECT ORDER of nodes
    PYTHON solution has correct order of nodes
*/

import trees.util.TreeNode;

//public class Q543_diameterOfBinaryTree_FollowUp {
//    int diameter = 0;
//    List<TreeNode> maxPath;
//    public int diameterOfBinaryTree(TreeNode root) {
//        var path = recurseMaxPath(root);
//        for(var node : maxPath){
//            System.out.println(node.val);
//        }
//        return diameter;
//    }
//
//    public List<TreeNode> recurseMaxPath(TreeNode root) {
//        if(root == null)
//            return new LinkedList<>();
//
//        var leftPath = recurseMaxPath(root.left);
//        var rightPath = recurseMaxPath(root.right);
//        if(leftPath.size() + rightPath.size() > diameter){
//            maxPath = new ArrayList<>(leftPath);
//            maxPath.add(root);
//            maxPath.addAll(rightPath);
//            diameter = leftPath.size() + rightPath.size();
//        }
//
//        var path = new LinkedList<>(leftPath.size() > rightPath.size() ? leftPath : rightPath);
//        path.addLast(root);
//        return path;
//    }
//}

/*
    "construct path as you backtrack upwards, just like how you calculate height as you backtrack upwards.
    In other words can be broken down into recursive subproblem of: "If I know the paths of my left and right children,
    then I just need to add my own value to construct my path downwards"."

    This works correctly but it is not a single list but two lists from single node
*/


class Q543_diameterOfBinaryTree_FollowUp {
    Value maxLeftVal = null;
    Value maxRightVal = null;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        System.out.println(maxLeftVal.path);
        System.out.print(maxRightVal.path);
        return maxLeftVal.height + maxRightVal.height;
    }

    private Value calculateDiameter(TreeNode curr) {
        if (curr == null) {
            return null;
        }

        Value leftVal = calculateDiameter(curr.left);
        Value rightVal = calculateDiameter(curr.right);

        int leftHeight = leftVal == null ? 0 : leftVal.height + 1;
        String leftPath = leftVal == null ? String.valueOf(curr.val) : curr.val + "->" + leftVal.path;
        Value currLeftVal = new Value(leftHeight, leftPath);

        int rightHeight = rightVal == null ? 0 : rightVal.height + 1;
        String rightPath = rightVal == null ? String.valueOf(curr.val) : curr.val + "->" + rightVal.path;
        Value currRightVal = new Value(rightHeight, rightPath);

        int maxLeftHeight = maxLeftVal == null ? 0 : maxLeftVal.height;
        int maxRightHeight = maxRightVal == null ? 0 : maxRightVal.height;
        // when we have a tree with just a root node, this if statement needs to be run
        // so use >= due since we initialize maxLeftVal and maxRightVal to 0
        if (leftHeight + rightHeight >= maxLeftHeight + maxRightHeight) {
            maxLeftVal = currLeftVal;
            maxRightVal = currRightVal;
        }

        return currLeftVal.height > currRightVal.height ? currLeftVal : currRightVal;
    }

    class Value {
        int height;
        String path;

        public Value(int height, String path) {
            this.height = height;
            this.path = path;
        }
    }
}