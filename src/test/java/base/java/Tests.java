package base.java;


import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
}
