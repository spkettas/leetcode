package util;

import java.util.*;

/**
 * 打印工具库
 */
public class MyPrint {
    /**
     * 打印数组
     *
     * @param nums
     */
    public static void show(int[] nums) {
        for (int i : nums) {
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    /**
     * 打印二维数组
     *
     * @param nums
     */
    public static void show(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        System.out.println("[");
        for (int i = 0; i < m; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println("]");
        }

        System.out.println("]");
    }

    /**
     * 打印列表
     *
     * @param list
     */
    public static void showStrs(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();
    }

    public static void show(List<Integer> list) {
        for (Integer l : list) {
            System.out.print("" + l + "\t");
        }

        System.out.println();
    }

    // Integer
    public static void showList(List<List<Integer>> list) {
        System.out.println("[");
        for (int i = 0; i < list.size(); ++i) {
            List<Integer> eles = list.get(i);

            System.out.print("[");
            for (Integer l : eles) {
                System.out.print(l + "\t");
            }

            System.out.println("]");
        }

        System.out.println("]");
    }

    // String
    public static void showStr(List<List<String>> list) {
        for (int i = 0; i < list.size(); ++i) {
            List<String> eles = list.get(i);

            System.out.println("> " + i);
            for (String l : eles) {
                System.out.print("" + l + "\t");
            }

            System.out.println();
        }
    }

    // link
    public static void showList(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.print(p.val + "\t");
            p = p.next;
        }
        System.out.println();
    }

    public static void _show(TreeNode head) {
        if (head == null) {
            System.out.print("\tnull");
            return;
        }

        System.out.print("\t" + head.val);
        _show(head.left);
        _show(head.right);
    }

    public static void show(TreeNode head) {
        _show(head);
        System.out.println();
    }
}
