import java.util.Arrays;

/**
 * @Author: mafei0728
 * @Date: 2021/7/3 15:39
 * @Description:
 */

public class Test {
    public static void main(String[] args) {
        System.out.println(fun("20-21", 21));


    }

    public static String fun(String s, int a) {

        if (!s.contains("-")) {
            return "";
        }
        String[] ss = s.split("-");
        int m = Integer.parseInt(ss[0]);
        int n = Integer.parseInt(ss[1]);
        if (a < m || a > n) {
            return "";
        }
        int start = a - 1;
        int stop = a + 1;
        if (m == a) {
            if (n == stop) {
                return n + "";
            } else {
                return stop + "-" + n;
            }
        } else if (n == a) {
            if (start == m) {
                return m + "";
            } else {
                return m + "-" + start;
            }
        } else if (start == stop) {
            return m + "," + n;
        } else if (m == start) {
            return m + "," + stop + "-" + n;
        } else if (n == stop) {
            return m + "-" + start + "," + n;
        } else {
            return m + "-" + start + "," + stop + "-" + n;
        }
    }
}
