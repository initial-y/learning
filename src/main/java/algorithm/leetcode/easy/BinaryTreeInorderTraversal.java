package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树-中序遍历
 * @author initial.y
 * @className BinaryTreeInorderTraversal
 * @description
 * @date 2021/10/11
 * @num 94
 */
public class BinaryTreeInorderTraversal {

    /**
     * 递归-中序遍历
     * @param root
     * @return
     */
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

    /**
     * 迭代-中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> nodeList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nodeList.add(cur.val);
            cur = cur.right;
        }
        return nodeList;
    }

}
