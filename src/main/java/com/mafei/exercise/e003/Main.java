/**
 * @Author: mafei0728
 * @Date: 2021/7/3 16:49
 * @Description:
 */
package com.mafei.exercise.e003;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.println(mainFun());

    }

    public static int mainFun() {
        Scanner sc = new Scanner(System.in);
        String mn = sc.nextLine();
        int nCount = Integer.parseInt(mn.split(",")[0]);
        int mCount = Integer.parseInt(mn.split(",")[1]);
        int[] vc = new int[mCount + 1];
        String [] money = new String [mCount];
        for (int i = 0; i < nCount; i++) {
            String tx = sc.nextLine();
            String[] sp = tx.split(",");
            int vv = Integer.parseInt(sp[0]);
            vc[vv]++;
            money[i] = tx;
        }
        // 找出目前最高的票数量
        int maxVote = max(vc);
        // 找出目前最高票数的店铺
        int mt = Arrays.binarySearch(vc, maxVote);
        // 价格排序

        Arrays.sort(money, (o1, o2) -> Integer.parseInt(o1.split(",")[1]) - Integer.parseInt(o2.split(",")[1]));

        if (mt == 1) {
            return 0;
        }
        // 达到票数之前我们总是要找最少的价格,有两种情况, mt
        int minM = 0;
        for (int i = vc[1], k=0; i <= maxVote; i++, k++){
                int mFlag = Integer.parseInt(money[k].split(",")[0]);
                int monFlag = Integer.parseInt(money[k].split(",")[1]);
                minM += monFlag;
                if (mFlag == mt) {
                    maxVote--;
                }
        }
        return minM;

    }

    public static int max(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
            }
        }
        return temp;
    }
}
