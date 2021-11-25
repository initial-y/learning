package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树-层序遍历
 * @author initial.y
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
        List<List<Integer>> orderList = new ArrayList<>();
        if (root == null) {
            return orderList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // levelSize记录该层的叶节点个数
            int levelSize = queue.size();

            List<Integer> levelList = new ArrayList<>();
            // 循环当前层, 并把下一层节点加入queue
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            orderList.add(levelList);
        }
        return orderList;
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
            // 出队
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
