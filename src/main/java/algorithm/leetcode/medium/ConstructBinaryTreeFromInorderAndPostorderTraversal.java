package algorithm.leetcode.medium;

import algorithm.leetcode.TreeNode;

/**
 * @author intial.y
 * @className ConstructBinaryTreeFromInorderAndPostorderTraversal
 * @description
 * @date 2021/11/19
 * @num 106
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return this.build(inorder, 0, inorder.length -1,
                postorder, 0, postorder.length -1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        int inOrderIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                inOrderIndex = i;
                break;
            }
        }

        int leftSize = inOrderIndex - inStart;
        TreeNode root = new TreeNode(rootValue);
        // 此处注意postorder取值范围, 左子树postorder[postStart, postStart + leftSize - 1], 右子树postorder[postStart + leftSize, postEnd - 1]
        root.left = this.build(inorder, inStart, inOrderIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = this.build(inorder, inOrderIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

}
