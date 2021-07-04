/**
 * @Author: mafei0728
 * @Date: 2021/7/3 11:48
 * @Description: vlan  第一行输入vlan的范围,第二行数据取出的vlan 输出排序好的结果
 * example 1:
 * in:
 * 1-5,9,10,6
 * 3
 * out:
 * 1-2,4-5,6,9,10
 */
package com.mafei.exercise.e001;

import javafx.print.Collation;
import scala.Int;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("请输入xxx");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] arr = s.split(",");
            ArrayList<String> al = new ArrayList<>();
            al.addAll(Arrays.asList(arr));
            String k = sc.nextLine();
            al.add(k);
            Comparator<String> compare = (o1, o2) -> {
                int a = Integer.parseInt((o1.split("-"))[0]);
                int b = Integer.parseInt((o2.split("-"))[0]);
                return a - b;
            };
            Collections.sort(al, compare);
            System.out.println(al);
            int index = al.lastIndexOf(k);
            String t = al.get(index - 1);
            al.remove(k);
            al.remove(t);
            String tx = fun(t, Integer.parseInt(k));
            if (tx != "") {
                String [] gx = tx.split(",");
                for (String tt : gx){
                    al.add(tt);
                }
            }
            Collections.sort(al, compare);
            System.out.println(al);

            String r = "";
            for (String tt : al) {
                r += tt + ",";
            }
            System.out.println(r.substring(0, r.length() - 1));


        }
    }
// 20-21,15,18,30,5-10
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
