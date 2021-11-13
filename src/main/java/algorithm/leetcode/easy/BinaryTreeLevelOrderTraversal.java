package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树-层序遍历
 * @author xin.yang
 * @className BinaryTreeLevelOrderTraversal
 * @description
 * @date 2021/10/11
 * @num 102
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 层序遍历, 要求返回二维数组
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        return null;
    }


    /**
     * 普通bfs
     * @param root
     * @return 返回一维数组
     */
    public Queue<TreeNode> bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return queue;
    }
}
