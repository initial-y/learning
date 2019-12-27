package tdd.fizzbuzz;

/**
 * @className: FizzBuzz
 * @author: yang
 * @date: 2019/12/27
 */
public class FizzBuzz {

    public void printFizzBuzz(int n) {
        if (n > 0 && n <= 100) {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }


    }

}
