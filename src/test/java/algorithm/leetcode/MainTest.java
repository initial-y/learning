package algorithm.leetcode;


import java.util.*;

/**
 * @className: MainTest
 * @author: yangxin
 * @date: 2020/4/3
 */
public class MainTest {

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

    private static void getUnrepeatableString() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder sb = new StringBuilder();
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            LinkedHashSet set = new LinkedHashSet(50);
            for (char c : arr) {
                set.add(c);
            }

            set.stream().forEach(s -> {
                sb.append(s);
            });
            System.out.println(sb.toString());
        }
    }

    private static void getLastWordLength() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String words = sc.nextLine();
            String[] arr = words.split("\\s+");
            System.out.println(arr[arr.length -1].length());
        }
    }

    private static void getCharNum() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String c  = sc.nextLine();
            char[] arr = str.toCharArray();
            List<String> strList = new ArrayList<>();
            for (char c1 : arr) {
                strList.add(String.valueOf(c1));
            }
            int num = (int) strList.stream().filter(s -> c.equalsIgnoreCase(s)).count();
            System.out.println(num);
        }
    }

    private static void getEightLengthStr() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int length = str.length();
            int addLength = 8 - length%8;
            StringBuilder sb = new StringBuilder(str);
            if (addLength < 8) {
                for (int i = 0; i< addLength ; i++) {
                    sb.append("0");
                }
            }
            str = sb.toString();
            while (str.length()>0) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }
        }
    }

    // 质因子
    private static void getPrimeNum() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long num = sc.nextLong();
            getPrime(num);
        }
    }

    private static void getPrime(long num) {

        for (int i= 2;i <= num; i++){
            if (num % i==0){
                System.out.print(i + " ");
                getPrime(num/i);
                break;
            }
            if (i==num){
                System.out.print( i + "");
            }
        }
    }

    // 近似整数值
    private static void getApproximateInteger() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double num = sc.nextDouble();
            System.out.println(Math.round(num));
        }
    }

    // 输出合并后的键值对（多行）
    private static void printMergedKeyValue() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = Integer.parseInt(sc.nextLine());
            // todo 为什么要treeMap hashMap不行
            Map<Long, Long> map = new TreeMap<>();
            for (int i = 0; i < num; i++) {
                String str = sc.nextLine();
                long key = Integer.parseInt(str.split("\\s+")[0]);
                long value = Integer.parseInt(str.split("\\s+")[1]);

                if(map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else {
                    map.put(key,value);
                }
            }

            for (Long key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }

    // 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
    private static void getUnRepeatableNumInteger() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Integer num = sc.nextInt();
            char[] charArr = String.valueOf(num).toCharArray();
            Set set = new LinkedHashSet();
            for (int i = charArr.length - 1; i >= 0; i --) {
                set.add(charArr[i]);
            }
            StringBuilder sb = new StringBuilder();
            set.forEach(s -> sb.append(s));
            System.out.println(sb.toString());
        }
    }

    // 输出范围在(0~127)字符的个数
    private static void printInAscRangeNum() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] charArr = str.toCharArray();
            Set set = new HashSet();
            for (char c : charArr) {
                if (c>=0 && c <= 127) {
                    set.add(c);
                }
            }
            System.out.println(set.size());
        }
    }

    // 将这个整数以字符串的形式逆序输出
    private static void printNumReversed() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] charArr = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = charArr.length - 1; i >= 0; i--) {
                sb.append(charArr[i]);
            }
            System.out.println(sb.toString());
        }
    }

    // 得到逆序的句子
    private static void getReverseSentence() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String sentence = sc.nextLine();
            System.out.println(reverse(sentence));
        }
    }

    public static String reverse(String sentence) {
        String[] charArr = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) {
            sb.append(charArr[i] + " ");
        }
        return sb.toString();
    }


    // 数据输出n行，输出结果为按照字典序排列的字符串。
    private static void printSortedStr() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = Integer.parseInt(sc.nextLine());
            List list = new ArrayList();
            for (int i = 0; i < num; i++) {
                list.add(sc.nextLine());
            }
            Collections.sort(list);
            list.forEach(System.out::println);
        }
    }

    // 这个数转换成2进制后，输出1的个数
    private static void printBinary1Num() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Integer num = sc.nextInt();
            String binaryNumStr = Integer.toBinaryString(num);
            char[] charArr = binaryNumStr.toCharArray();
            int binary1Num = 0;
            for (char c : charArr) {
                int i = Integer.parseInt(String.valueOf(c));
                if (i == 1) {
                    binary1Num ++;
                }
            }
            System.out.println(binary1Num);

        }
    }

    protected static void printMaxGoodsValue() {

//        Scanner scanner = new Scanner(System.in);
//        // 总钱数
//        int N = scanner.nextInt();
//        // 购买物品个数
//        int m = scanner.nextInt();
//        int[] f = new int[N + 1];
//        // 分组，goods[i][0]为主件，goods[i][1]为附件1，goods[i][2]为附件2
//        Good[][] goods1= new Good[60][4];
//
//        for (int i = 1; i <= m; i++) {
//            int v = scanner.nextInt();
//            int p = scanner.nextInt();
//            int q = scanner.nextInt();
//
//            Good t = new Good(v, v * p);
//            if (q == 0) {
//                goods1[i][0] = t;
//            } else {
//                if (goods1[q][1] == null) {
//                    goods1[q][1] = t;
//                } else {
//                    goods1[q][2] = t;
//                }
//            }
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = N; j >= 0 && goods1[i][0] != null; j--) {
//                //以下代码从分组中选择价值最大的。共五种情况：不选主件，选主件，选附件1和主件，选附件2和主件，选附件1和附件2和主件
//                Good master = goods1[i][0];
//                int max = f[j];
//                if (j >= master.v && max < f[j - master.v] + master.vp) {
//                    max = f[j - master.v] + master.vp;
//                }
//                int vt;
//                if (goods1[i][1] != null) {
//                    if (j >= (vt = master.v + goods1[i][1].v)
//                            && max <  f[j - vt] + master.vp + goods1[i][1].vp) {
//                        max = f[j - vt] + master.vp + goods1[i][1].vp;
//                    }
//                }
//                if (goods1[i][2] != null) {
//                    if (j >= (vt = master.v + goods1[i][1].v + goods1[i][2].v)
//                            && max < f[j - vt] + master.vp + goods1[i][1].vp + goods1[i][2].vp) {
//                        max = f[j - vt] + master.vp + goods1[i][1].vp + goods1[i][2].vp;
//                    }
//                }
//                f[j] = max;
//            }
//        }
//
//        System.out.println(f[N]);
    }

//    public class Good {
//        int v;
//        int vp;
//        public Good(int v, int vp) {
//            this.v = v;
//            this.vp = vp;
//        }
//    }

    public static void main(String[] args) {

        printBinary1Num();
    }

}