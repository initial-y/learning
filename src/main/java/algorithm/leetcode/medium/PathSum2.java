package algorithm.leetcode.medium;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author initial.y
 * @className PathSum2
 * @description
 * @date 2021/11/22
 * @num 113
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        generatePath(root, targetSum, path, result);
        return result;
    }

    private void generatePath(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                // 新建list保存
                result.add(new ArrayList<>(path));
            }
        }
        generatePath(root.left, targetSum - root.val, path, result);
        generatePath(root.right, targetSum - root.val, path, result);
        // 移除末尾元素 todo why?
        path.remove(path.size() - 1);
    }

}
