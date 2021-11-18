package base.java;


import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @className Test
 * @description 
 * @date 2021/04/28
 */
public class Tests {

    @Test
    public void testInterval() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime tomorrowStart = LocalDateTime.of(now.plusDays(1L).toLocalDate(), LocalTime.MIN);
        System.out.println(tomorrowStart);
        long minutes = Duration.between(now, tomorrowStart).getSeconds();
        System.out.println(minutes);

        LocalDateTime time = LocalDateTime.of(2021, 9, 10, 10,44, 55, 435);
        System.out.println(time.plusSeconds(47704 + 1));
    }


    @Test
    public void testCollectionSubtract() {
        List<Integer> cxList = Arrays.asList(1,2,3,4);
        List<Integer> chList = new ArrayList<>();
        List<Integer> diff = (List<Integer>) CollectionUtils.union(cxList, chList);
        System.out.println(CollectionUtils.subtract(cxList, chList));
    }

    @Test
    public void testSet() {
        Set<BigDecimal> set = new HashSet<>();
        set.add(new BigDecimal("0.130"));
        set.add(new BigDecimal("0.1300"));
        set = set.stream().map(BigDecimal :: stripTrailingZeros).collect(Collectors.toSet());
        System.out.println(set);
    }


    @Test
    public void testBigDecimal() {
        List<BigDecimal> c1 = Arrays.asList(new BigDecimal("0.13"), new BigDecimal("0.1100"));
        List<BigDecimal> c2 = Arrays.asList(new BigDecimal("0.09"), null);
        List<BigDecimal> union = (List<BigDecimal>) CollectionUtils.union(c1, c2);
//        List<BigDecimal> union = CollectionUtils.union(c1, c2).stream().map(BigDecimal::stripTrailingZeros).collect(Collectors.toList());
        System.out.println(union);
    }


}
