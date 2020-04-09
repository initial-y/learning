package algorithm.leetcode.medium;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @className: MediumTest
 * @author: yangxin
 * @date: 2020/4/9
 */
public class MediumTest {

    private static final Gson gson = new Gson();

    @Test
    public void test_RemoveDuplicates2_removeDuplicates() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int length = new RemoveDuplicates2().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        assertEquals(length, 5);
        assertEquals(nums[0], 1);
        assertEquals(nums[2], 2);
    }

    @Test
    public void test_GenerateParentheses_generateParenthesis() {
        List<String> parenthesis = new GenerateParentheses().generateParenthesis(3);
        System.out.println(gson.toJson(parenthesis));
        assertEquals(parenthesis.size(), 5);
    }
}
