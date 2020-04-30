package algorithm.datastructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName MyBSTTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/23
 */
public class MyBSTTest {

    @Test
    public void test_pre_order() {
        MyBST<Integer> bst = new MyBST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println("--");
        System.out.println(bst);
    }

    @Test
    public void test_pre_order_non_recursive() {
        MyBST<Integer> bst = new MyBST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrderNonRecursive();
    }

    @Test
    public void test_in_order() {
        MyBST<Integer> bst = new MyBST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.inOrder();
    }

    @Test
    public void test_post_order() {
        MyBST<Integer> bst = new MyBST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.postOrder();
    }

    @Test
    public void test_level_order() {
        MyBST<Integer> bst = new MyBST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.levelOrder();
    }

    @Test
    public void test_remove() {
        MyBST<Integer> bst = new MyBST<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            bst.add(random.nextInt(1000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw  new IllegalArgumentException("error");
            }
        }
        System.out.println("success");
    }
}
