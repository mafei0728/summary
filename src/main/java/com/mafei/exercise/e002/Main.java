/**
 * @Author: mafei0728
 * @Date: 2021/7/3 16:41
 * @Description:
 */
package com.mafei.exercise.e002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int max = 0;
        String[] sa = s.split(",");
        for (int i = 0; i < sa.length; i++) {
            for (int j = i + 1; j < sa.length; j++) {
                if ( fun(sa[i], sa[j]) == 0){
                    continue;
                } else {
                    max = Math.max(max, sa[i].length() * sa[j].length());
                }
            }
        }
        System.out.println(max);
    }

    public static int fun(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
