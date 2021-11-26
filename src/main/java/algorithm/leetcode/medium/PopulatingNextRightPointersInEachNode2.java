package algorithm.leetcode.medium;

import algorithm.leetcode.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author initial.y
 * @className PopulatingNextRightPointersInEachNode2
 * @description
 * @date 2021/11/26
 * @num 117
 */
public class PopulatingNextRightPointersInEachNode2 {

    /**
     * ac版本
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> nodeList = new ArrayList<>();

            for (int i = 0; i< size; i++) {
                Node head = queue.poll();
                nodeList.add(head);

                if (head.left != null) {
                    queue.offer(head.left);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                }
            }

            for (int i = 0; i < nodeList.size() - 1; i++) {
                nodeList.get(i).next = nodeList.get(i+1);
            }

        }

        return root;
    }
}
