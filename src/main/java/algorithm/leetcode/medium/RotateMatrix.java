package algorithm.leetcode.medium;

/**
 * @ClassName RotateMatrix
 * @Descripiton
 * @Author initial_yang
 * @see https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * @Date 2020/4/7
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(newMatrix[i], 0, matrix[i], 0, n);
        }
    }
}
