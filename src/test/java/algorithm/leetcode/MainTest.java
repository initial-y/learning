package algorithm.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @className: MainTest
 * @author: yangxin
 * @date: 2020/4/3
 */
public class MainTest {

    public static void main(String[] args) {

        deleteNum();
    }


    private static int getDrink(int bottle) {

        //        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int bottle = sc.nextInt();
//            if (bottle != 0) {
////                System.out.println(bottle/2);
//                System.out.println(getDrink(bottle));
//            }
//        }

        if (bottle == 1) {
            return 0;
        }
        if (bottle == 2) {
            return 1;
        }
        int drink = bottle / 3;
        int remain = bottle % 3;
        return drink + getDrink(drink + remain);
    }

    private static void getSortedList() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<Integer> list = new ArrayList<>(100);
            int head = sc.nextInt();
            if (head > 0) {
                for (int i = 0; i < head; i++) {
                    list.add(sc.nextInt());
                }
            }
            list.stream().distinct().sorted(Integer::compareTo).forEach(System.out::println);
        }
    }

    private static void printDecimal() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String sixteen = sc.nextLine();
            if (sixteen.trim().length() > 1) {
                String num = sixteen.substring(2);
                System.out.println(Integer.valueOf(num, 16));
            } else {
                System.out.println(Integer.valueOf(sixteen));
            }
        }
    }

    private static void deleteNum() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();

            if (num > 1000) {
                num = 999;
            }
            Queue list = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                list.offer(i);
            }

            while (list.size() != 1) {
                for (int j = 0; j < 2; j++) {
                    list.offer(list.poll());
                }
                list.poll();
            }
            System.out.println(list.poll());
        }
    }


}