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

