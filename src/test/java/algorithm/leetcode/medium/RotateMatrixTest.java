package algorithm.leetcode.medium;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * @ClassName RotateMatrixTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/7
 */
public class RotateMatrixTest {

    @Test
    public void test_rotate_matrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotateMatrix = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        new RotateMatrix().rotate(matrix);
        System.out.println(new Gson().toJson(matrix));
    }
}
