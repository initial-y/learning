package algorithm.datastructure;

import org.junit.Test;

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

}
