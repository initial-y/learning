package tdd.fizzbuzz;

import static java.lang.String.valueOf;

public class FizzBuzzThird {

    private int num;

    public FizzBuzzThird(int i) {
        this.num = i;
    }

    @Override
    public String toString() {
        if (isRelateToNum(3) && isRelateToNum(5)) {
            return "fizzbuzz";
        }
        if (isRelateToNum(3)) {
            return "fizz";
        }
        if (isRelateToNum(5)) {
            return "buzz";
        }
        return valueOf(num);
    }

    private boolean isRelateToNum(int i) {
        return num % i == 0 || valueOf(num).contains(valueOf(i));
    }
}
