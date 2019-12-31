package tdd.fizzbuzz;

public class FizzBuzzFirst {

    private int rawNum;

    public FizzBuzzFirst(int num) {
        this.rawNum = num;
    }

    @Override
    public String toString() {
        /**
         * 批量修改方法名快捷键: shift + F6
         */
        if (isRelateToNum(3) && isRelateToNum(5)) {
            return "fizzbuzz";
        }
        if (isRelateToNum(3)) {
            return "fizz";
        }
        if (isRelateToNum(5)) {
            return "buzz";
        }
        return String.valueOf(rawNum);
    }

    private boolean isRelateToNum(int i) {
        return rawNum % i == 0 || String.valueOf(rawNum).contains(String.valueOf(i));
    }
}
