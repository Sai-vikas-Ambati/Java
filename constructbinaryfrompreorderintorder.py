# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        inorder_index_map = {value: index for index, value in enumerate(inorder)}
        self.preorder_index = 0

        def array_to_tree(left: int, right: int) -> Optional[TreeNode]:
            if left > right:
                return None

            root_val = preorder[self.preorder_index]
            self.preorder_index += 1

            root = TreeNode(root_val)

            # Build left and right subtrees
            root.left = array_to_tree(left, inorder_index_map[root_val] - 1)
            root.right = array_to_tree(inorder_index_map[root_val] + 1, right)

            return root

        return array_to_tree(0, len(inorder) - 1)