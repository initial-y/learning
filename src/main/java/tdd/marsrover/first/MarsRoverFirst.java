package tdd.marsrover.first;

import java.util.List;

/**
 * @ClassName MarsRoverFirst
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/1/15
 */
public class MarsRoverFirst {

    private int length;
    private int width;
    private int x;
    private int y;
    private String direction;

    public MarsRoverFirst(int length, int width, int initX, int initY, String initDirect) {
        this.length = length;
        this.width = width;
        this.x = initX;
        this.y = initY;
        this.direction = initDirect;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public void executeCommands(List<String> commands) {
        commands.forEach(command -> {
            switch (direction) {
                case "N":
                    switch (command) {
                        case "f":
                            ++y;
                            break;
                        case "b":
                            --y;
                            break;
                        case "l":
                            direction = "W";
                            break;
                        case "r":
                            direction = "E";
                            break;
                        default:
                            break;
                    }
                    break;
                case "S":
                    switch (command) {
                        case "f":
                            --y;
                            break;
                        case "b":
                            ++y;
                            break;
                        case "l":
                            direction = "E";
                            break;
                        case "r":
                            direction = "W";
                            break;
                        default:
                            break;
                    }
                    break;
                case "E":
                    switch (command) {
                        case "f":
                            ++x;
                            break;
                        case "b":
                            --x;
                            break;
                        case "l":
                            direction = "N";
                            break;
                        case "r":
                            direction = "S";
                            break;
                        default:
                            break;
                    }
                    break;
                case "W":
                    switch (command) {
                        case "f":
                            x--;
                            break;
                        case "b":
                            x++;
                            break;
                        case "l":
                            direction = "S";
                            break;
                        case "r":
                            direction = "N";
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        });
    }

    public String getDirection() {
        return direction;
    }
}
