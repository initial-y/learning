package tdd.marsrover.first;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 任务拆分
 * 1. 确定方向 + 前进/后退, 位置(x/y值)变更
 * 2. 确定位置 + 调转方向, 方向(NSEW)变化
 * 新需求
 * 1. 不能超出指定范围
 * 2. 障碍物停止移动
 *
 * @ClassName MarsRoverFirstTest
 * @Author initial_yang
 * @Date 2020/1/15
 */
public class MarsRoverFirstTest {

    @Test
    public void should_change_position_when_forward_or_back() {
        MarsRoverFirst first = new MarsRoverFirst(50, 50, 0, 0, "E");
        first.executeCommands(Arrays.asList("f", "f", "b"));
        assertEquals(first.getX(), 1);
    }

    @Test
    public void should_change_direction_when_left_or_right() {
        MarsRoverFirst first = new MarsRoverFirst(50, 50, 0, 0, "E");
        first.executeCommands(Arrays.asList("l", "l", "r"));
        assertEquals(first.getDirection(), "N");
    }

    @Test
    public void should_return_bounds_position_when_meet_bounds() {
        MarsRoverFirst first = new MarsRoverFirst(50, 50, 0, 0, "E");
        first.executeCommands(Arrays.asList( "b"));
        assertEquals(first.getX(), 0);
    }


    @Test
    public void test() {
        System.out.println(Math.abs(-1));
    }

}
