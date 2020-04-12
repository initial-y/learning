package naver;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TestNaverCachedData
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/12
 */
public class TestNaverCachedData {

    @Test
    public void test_processCachedData() {
        NaverCachedData<Integer> cachedData = new NaverCachedData<>();
        List<Integer> nums = Arrays.asList(1, 1, 3);
        nums.parallelStream().forEach(num -> cachedData.processCachedData(num));
    }

}
