package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树-中序遍历
 * @author initial.y
 * @className BinaryTreeInorderTraversal
 * @description
 * @date 2021/10/11
 * @num 94
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        this.dfs(root,nodeList);
        return nodeList;
    }

    private void dfs(TreeNode node, List<Integer> nodeList) {
        if (node != null) {
            this.dfs(node.left, nodeList);
            nodeList.add(node.val);
            this.dfs(node.right, nodeList);
        }
    }

}
