package tdd.fizzbuzz;

import static java.lang.String.valueOf;

public class FizzBuzzSecond {

    private int num;

    public FizzBuzzSecond(int i) {
        num = i;
    }

    @Override
    public String toString() {
        if (isDivideByNum(3) && isDivideByNum(5)) {
            return "fizzbuzz";
        }
        if (isDivideByNum(3)) {
            return "fizz";
        }
        if (isDivideByNum(5)) {
            return "buzz";
        }
        return valueOf(num);
    }

    private boolean isDivideByNum(int i) {
        return num % i == 0;
    }
}
