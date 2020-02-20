package algorithm.leetcode.easy;

/**
 * @ClassName DayOfTheYearDemo
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/20
 */
public class DayOfTheYearDemo {
    public int getDayOfYear(String date) {
        if (date == null || "".equals(date)) {
            return -1;
        }
        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);

        int days = 0;
        boolean isLeapYear = checkIsLeapYear(year);
        for (int i = 1; i <= month -1; i++) {
            days += getMonthDays(i, isLeapYear);
        }
        days += day;

        return days;
    }

    /**
     * 是否是闰年
     * @description 被4整除&&不被100整除： 小闰； 被400整除： 大闰
     * @param year
     * @return
     */
    private boolean checkIsLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 ==0;
    }

    private int getMonthDays(int month, boolean isLeapYear) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return isLeapYear ? 29 : 28;
            default:
                return 30;
        }
    }
}
