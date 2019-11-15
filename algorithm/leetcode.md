## Data Structure

### Array and String

#### [724. Find Pivot Index]( https://leetcode.com/problems/find-pivot-index/ )

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

#### [747. Largest Number At Least Twice of Others ]( https://leetcode.com/problems/largest-number-at-least-twice-of-others/ )

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

#### [66. Plus One ]( https://leetcode.com/problems/plus-one/ )

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



