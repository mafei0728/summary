/**
 * @Author: mafei0728
 * @Date: 2021/7/3 23:20
 * @Description: 数组, 字符串反转
 */
package com.mafei.exercise.e004;

import javax.security.sasl.SaslClient;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private  String a;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Main)) {
            return false;
        }
        Main main = (Main) o;
        return Objects.equals(a, main.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            char [] c = s.toCharArray();
            fun(c);
            System.out.println(new String(c));
        }
    }

    public static void fun(char[] args) {
        int n = args.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            char temp = args[i];
            args[i] = args[j];
            args[j] = temp;
        }
    }
}
