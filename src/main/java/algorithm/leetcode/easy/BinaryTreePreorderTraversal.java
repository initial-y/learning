package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树-前序遍历
 * @author intial.y
 * @className BinaryTreePreorderTraversal
 * @description
 * @date 2021/10/11
 * @num 144
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        this.dfs(root, nodeList);
        return nodeList;
    }

    private void dfs(TreeNode node, List<Integer> nodeList) {
        if (node != null) {
            nodeList.add(node.val);
            this.dfs(node.left, nodeList);
            this.dfs(node.right, nodeList);
        }
    }
}
