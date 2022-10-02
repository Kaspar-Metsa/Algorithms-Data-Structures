package trees.Q1430_validSequence;

import trees.util.TreeNode;

public class Q1430_validSequence_DFS {



/*
    Time complexity O(N) because we traverse each node once.
    Space complexity O(N) for recursion stack if skewed tree.
*/

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return find_path_recursive(root, arr, 0);
    }

    boolean find_path_recursive(TreeNode currentNode, int[] seq, int depth) {
        if (currentNode == null || depth >= seq.length || currentNode.val != seq[depth]) {
            return false;
        }
        // 'depth == seq.length - 1' means ends of sequence
        if (currentNode.left == null && currentNode.right == null && depth == seq.length - 1) {
            return true;
        }

        return find_path_recursive(currentNode.left, seq, depth + 1) ||
                find_path_recursive(currentNode.right, seq, depth + 1);
    }





    /*
    MY WRONG SOLUTION
    https://docs.google.com/document/d/1pzwakNOaH-P5sKli6uMGfCiFMW9dEAbfdetodmMAo1w/edit#
    n=nodes in tree
    m=elements in array
    Time O(max(m,n))
    Space O(max(h,n))
    public boolean isValidSequence(TreeNode root, int[] arr) {
        List<Integer> targetList = Arrays.stream(arr).boxed().collect(Collectors.toList()); //O(n)
        LinkedList<Integer> curPath = new LinkedList<>();
        return traverse(root, curPath, targetList); // Stack space O(h)
    }

    boolean traverse(TreeNode node, LinkedList<Integer> curPath, List<Integer> targetList) {
        if (node == null) return false;
        curPath.add(node.val); //O(1)
        if (node.left == null && node.right == null) {
            if (curPath.equals(targetList)) { //O(n)
                return true;
            } else {
                curPath.removeLast(); //O(1)
                return false;
            }
        }
        boolean answer = traverse(node.left, curPath, targetList) || traverse(node.right, curPath, targetList);
        curPath.removeLast();
        return answer;
    }
    */
}
