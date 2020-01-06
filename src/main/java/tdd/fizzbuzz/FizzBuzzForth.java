package tdd.fizzbuzz;

import static java.lang.String.valueOf;

/**
 * @className: FizzBuzzForth
 * @date: 2020/1/6
 */
public class FizzBuzzForth {
    public int num;

    public FizzBuzzForth(int input) {
        this.num = input;
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
        return num % i == 0 || valueOf(num).contains(valueOf(i));
    }
}

