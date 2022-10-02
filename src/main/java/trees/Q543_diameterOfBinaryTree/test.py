class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if not root:
            return None

        self.max_length = 0
        self.node_list = []
        self.traverse(root)

        for node in self.node_list:
            print(node.val)

        return self.max_length

    def traverse(self, root):
        if not root:
            return (0, [])

        left_max, left_node_list = self.traverse(root.left)
        right_max, right_node_list = self.traverse(root.right)

        if left_max + right_max > self.max_length:
            self.max_length = left_max + right_max
            self.node_list = left_node_list + [root] + right_node_list[
                                                       ::-1]  # both fixes are on this line

        if left_max > right_max:
            return (left_max + 1, left_node_list + [root])
        else:
            return (right_max + 1, right_node_list + [root])

    #         1
    #        / \
    #       2   3
    #      / \
    #     4  5


# treenode1 = TreeNode(1)
# treenode2 = TreeNode(2)
# treenode3 = TreeNode(3)
# treenode4 = TreeNode(4)
# treenode5 = TreeNode(5)
#
# treenode1.left = treenode2
# treenode1.right = treenode3
#
# treenode2.left = treenode4
# treenode2.right = treenode5
#
# solution = Solution()
# print(solution.diameterOfBinaryTree(treenode1))

#      1
#     / \
#    2   3
#   / \
#   4  5
#   /   \
#   6    7
#  /      \
# 8       9

treenode1 = TreeNode(1)
treenode2 = TreeNode(2)
treenode3 = TreeNode(3)
treenode4 = TreeNode(4)
treenode5 = TreeNode(5)
treenode6 = TreeNode(6)
treenode7 = TreeNode(7)
treenode8 = TreeNode(8)
treenode9 = TreeNode(9)

treenode1.left = treenode2
treenode1.right = treenode3

treenode2.left = treenode4
treenode2.right = treenode5

treenode4.left = treenode6
treenode6.left = treenode8

treenode5.right = treenode7
treenode7.right = treenode9

solution = Solution()
print(solution.diameterOfBinaryTree(treenode1))
