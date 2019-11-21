## Data Structure

### Array

#### [724. Find Pivot Index](https://leetcode.com/problems/find-pivot-index/ )

```java
public class FindPivotIndex {

    /**
     * 低配版, 最初想到的版本
     * @description 时间复杂度O(n^2)
     * @param arr
     * @return
     */
    public static int findPivotIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // 外层循环没有利用起来, leftSum通过内存循环计算, rightSum其实可以不用计算(rightSum = totalSum - arr[i] - leftSum)
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            for (int left = 0; left < i; left++) {
                leftSum += arr[left];
            }
            int rightSum = 0;
            for (int right = i + 1; right < arr.length; right++) {
                rightSum += arr[right];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 高配版
     * @description 时间复杂度O(n), 空间复杂度O(1):leftSum + sum
     * @param arr
     * @return
     */
    public static int findPivotIndexPro(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }

        int leftSum = 0;
        // leftSum = sum - leftSum - arr[i]
        for (int i = 0; i < arr.length; i++) {
            if (leftSum == sum - arr[i] - leftSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(findPivotIndexPro(arr));
    }
    
}
```

#### [747. Largest Number At Least Twice of Others ](https://leetcode.com/problems/largest-number-at-least-twice-of-others/ )

```java
public class LargestNumberAtLeastTwiceOfOthers {

    /**
     * 初始版本
     * @description 时间复杂度O(n), 空间复杂度O(1), 遍历两次
     * @param nums
     * @return
     */
    public static int findLargestNumberAtLeastTwiceOfOthers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 优化: 此处可以不用关注maxNum,只关注maxIndex, maxNum可以通过maxIndex得到
        int maxNum = nums[0];
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }

        // 找到第二大的数
        int secondaryMaxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 第二大的数 != 最大的数
            // 优化: 此处不需要nums[i] < maxNum的条件
            if (i != maxIndex && nums[i] < maxNum && nums[i] > secondaryMaxNum) {
                secondaryMaxNum = nums[i];
            }

        }

        if (maxNum >= secondaryMaxNum * 2) {
            return maxIndex;
        }
        return -1;
    }

    /**
     * 官方版本
     * @description 时间复杂度O(n), 空间复杂度O(1), 遍历两次
     * @param nums
     * @return
     */
    public static int findLargestNumberAtLeastTwiceOfOthersPro(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 最大下标
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果存在一个数的2倍大于最大数, 那么表示满足条件的数不存在(findAny)
            if (i != maxIndex && nums[i] * 2 > nums[maxIndex]) {
                return -1;
            }
        }
        return maxIndex;
    }

    /**
     * LeetCode遍历一次的版本
     * @param nums
     * @return
     */
    public static int findLargestNumberAtLeastTwiceOfOthersLoopOnce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        // nums.length > 1
        int maxIndex = 0;
        int secondaryMaxIndex = 1;
        if (nums[0] < nums[1]) {
            maxIndex = 1;
            secondaryMaxIndex = 0;
        }

        // nums.length > 2才会进入循环
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                // nums[i] > num[maxIndex] >= nums[secondaryMaxIndex], 处理maxIndex, secondaryMaxIndex
                secondaryMaxIndex = maxIndex;
                maxIndex = i;
            } else if (nums[i] > nums[secondaryMaxIndex]) {
                // nums[secondaryMaxIndex] < num[i] < nums[maxIndex], 只处理secondaryMaxIndex
                secondaryMaxIndex = i;
            }
        }

        return nums[maxIndex] >= nums[secondaryMaxIndex] * 2 ? maxIndex : -1;

    }

    public static void main(String[] args) {
        int[] nums = {0,2,0,3};
        System.out.println(findLargestNumberAtLeastTwiceOfOthers(nums));
    }

}
```

#### [66. Plus One ](https://leetcode.com/problems/plus-one/ )

```java
public class PlusOne {

    /**
     * 错误案例, 未通过版本
     * @param digits
     * @return
     * @description 题目未限制数组长度, int, long来求和都可能出现越界问题
     */
    public static int[] plusOneFailed(int[] digits) {

        // 简单测试用例能通过, 数组过长会越界
        int num = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            num += digits[i] * Math.pow(10L, digits.length - 1 - i);
        }

        int plusNum = num + 1;
        int[] arr = new int[digits.length];
        if (plusNum / Math.pow(10L, digits.length - 1) >= 10) {
            arr = new int[digits.length + 1];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (plusNum / Math.pow(10L, arr.length - 1 - i));
            plusNum %= Math.pow(10L, arr.length - 1 - i);
        }
        return arr;
    }

    /**
     * 通过版本, 存在优化空间, do-while实现
     * @param digits
     * @return
     * @description 方法由求和转为操作数组本身, do..while 实现
     */
    public static int[] plusOnePassed(int[] digits) {

        int index = digits.length - 1;
        int last;

        // 从数组最后一个元素开始操作, 自增1后判断是否等于10
        do {
            last = digits[index] + 1;
            // 可以写成digits[index]=0
            digits[index] = last % 10;
            // index先判断再减1,不然会有越界问题
        } while (index-- > 0 && last == 10);

        // 如果上述循环结束后digits[0] = 0, 表明digits形如[9,...], 此时数组扩容1
        if (digits[0] == 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            // todo 循环可以去掉,digits形如[9,..], 自增后除第一位为1外其他位必然是0
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }

        return digits;
    }

    /**
     * LeetCode讨论区版本之一, for循环实现
     * @param digits
     * @return
     */
    public static int[] plusOneForLoop(int[] digits) {
        // 每一位都自增1, 如果自增后<=9, 及时返回
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            // 也可以先判断digits[i] < 9 ,在判断内自增1
            if (digits[i] <= 9) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // 此处不用判断digits[0]==0, 没有在for循环return表明数组需要扩容
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    /**
     * LeetCode讨论区实现之二: for + break 实现, 与plusOneForLoop版本相似, 一个用break, 一个用return
     * @param digits
     * @return
     */
    public static int[] plusOneForBreak(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }

        return digits;
    }

    /**
     * LeetCode讨论区版本之三, while实现, 更易理解
     * @param digits
     * @return
     */
    public static int[] plusOneWhile(int[] digits) {
        // carry可以理解成是进位
        int carry = 1;

        // 从最后一个数字开始
        int index = digits.length - 1;
        // 需要进位&&index不越界
        while (carry > 0 && index >= 0) {
            digits[index]++;
            if (digits[index] <= 9) {
                // <=9 不需要进位
                carry = 0;
            } else {
                // >9 需要进位, 取余
                digits[index] = digits[index] % 10;
            }
            index--;
        }

        // 循环完了都还需要进位,表明是[9,....]这种情况
        if (carry > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9};
        System.out.println(JSON.toJSONString(plusOneForLoop(digits)));

    }

}
```

### 2D Array

#### [498. Diagonal Traverse](https://leetcode.com/problems/diagonal-traverse/ )

```java
public class DiagonalTraverse {

    /**
     * 参考评论区大神版本之一, 个人认为最容易理解的版本
     *
     * @param matrix
     * @return
     * @description 1. 箭头走向: row + col为偶数时row--,col++; row+col为奇数时,col--,row++
     * 2. 处理边界
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];

        int row = 0;
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[row][col];
            // 左下->右上: row--, col+=
            if ((row + col) % 2 == 0) {
                if (row - 1 >= 0 && col + 1 < n) {
                    // 正常情况, 非顶点
                    row--;
                    col++;
                } else if (row == 0 && col + 1 < n) {
                    // 移动到上边界(非顶点), 改变方向
                    col++;
                } else if (col == n - 1 && row + 1 < m) {
                    // 移动到右边界(非顶点), 改变方向
                    row++;
                }
            } else {
                // row + col 为奇数, 右上->左下
                if (col - 1 >= 0 && row + 1 < m) {
                    // 正常情况, 非顶点
                    col--;
                    row++;
                } else if (col == 0 && row + 1 < m) {
                    // 左边界(非顶点), 改变方向
                    row++;
                } else if (row == m - 1 && col + 1 < n) {
                    // 下边界(非顶点), 改变方向
                    col++;
                }
            }
        }

        return arr;
    }

    /**
     * 评论区由上面版本衍生出来的版本, 因if else的顺序而导致IndexOutOfBound
     *
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrderIndexOutOfBound(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];

        int row = 0;
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[row][col];
            // 上移
            if ((row + col) % 2 == 0) {
                // 存在着row==0&&col==n-1的情况(右上角顶点), 此时应该row++, 此处是col++
                if (row == 0) {
                    col++;
                } else if (col == n - 1) { // 正确的顺序是先判断col==n-1, 再判断row==0
                    row++;
                } else {
                    row--;
                    col++;
                }
            } else { // 下移
                // 同理,存在着col==0&&row==m-1的情况(左下角顶点), 此时应该col++
                if (col == 0) {
                    row++;
                } else if (row == m - 1) {
                    col++;
                } else {
                    col--;
                    row++;
                }
            }
        }

        return arr;
    }

    /**
     * 评论区版本之二, 简洁但较难理解
     *
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrderConcise(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];

        int row = 0;
        int col = 0;
        int d = 1;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[row][col];
            row -= d;
            col += d;

            // 顺序很重要
            if (row >= m) {
                row = m - 1;
                col += 2;
                d = -d;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = -d;
            }
            if (row < 0) {
                row = 0;
                d = -d;
            }
            if (col < 0) {
                col = 0;
                d = -d;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(JSON.toJSONString(findDiagonalOrderConcise(matrix)));
    }
}
```

#### [54. Spiral Matrix ](https://leetcode.com/problems/spiral-matrix/ )

```java
public class SpiralMatrix {

    /**
     * 错误的思路
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrderFailed(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int length = m * n;
        ArrayList list = new ArrayList();

        // 循环起点依次是(0,0), (1,1), (2,2)...
        int row = 0;
        int col = 0;

        int rowDeduct = 0, colDeduct = 0;
        for (int i = 0; i < length; i++) {
            list.add(matrix[row][col]);

            // todo 循环
            if (col + 1 < n) {
                col++;
            } else if (col == n - 1 && row + 1 < m) {
                row++;
                rowDeduct++;
            } else if (col == n - 1 && row == m - 1) {
                col--;
                colDeduct++;
            } else if (col == 0 && row - 1 > 0) {
                row--;
            }
        }

        return list;
    }

    /**
     * LeetCode讨论区版本之一，思路相对清晰
     * @description 注意for循环里的list.size() < m * n不能省略
     *              在m != n的情况下，当最后一行/一列循环完成之后很可能会重复读到数据（执行另一个朝向的循环）
     *              list.size() < m * n能保证在执行最后一个正确的朝向后，能通过size的判断及时退出循环
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> list = new ArrayList<>(m * n);

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        while (list.size() < m * n) {
            // 从左往右, 行不变，列递增
            for (int j = left; j <= right && list.size() < m * n; j++) {
                list.add(matrix[top][j]);
            }
            // 执行完毕，top + 1
            top++;

            // 从上往下，列不变，行递增
            for (int i = top; i <= bottom && list.size() < m * n; i++) {
                list.add(matrix[i][right]);
            }
            // 执行完毕，right - 1
            right--;

            // 从右往左，行不变，列递减
            for (int j = right; j >= left && list.size() < m * n; j--) {
                list.add(matrix[bottom][j]);
            }
            // 执行完毕，bottom - 1
            bottom--;

            // 从下往上，列不变，行递减
            for (int i = bottom; i >= top && list.size() < m * n; i--) {
                list.add(matrix[i][left]);
            }
            // 执行完毕，left + 1
            left++;

        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(JSON.toJSONString(spiralOrder(matrix)));
    }
}
```

#### [118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)

```java
class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangleList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int subSize = i + 1;
            List<Integer> subList = new ArrayList<>();

            if (i == 0) {
                subList.add(1);
            } else {
                List<Integer> preList = triangleList.get(i - 1);
                for (int j = 0; j < subSize; j++) {
                    if (j == 0 || j == subSize -1) {
                        subList.add(1);
                    } else {
                        subList.add(preList.get(j) + preList.get(j - 1));
                    }
                }
            }
            triangleList.add(subList);
        }

        return triangleList;
    }
}
```

