package str;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 1.fibonacci数列变形，添加了限制条件
 * f(i) = f(i-1) + f(i-2)
 */
public class O46 {
    public int translateNum(int num) {
        if (num < 10)   return 1;

        char[] arr = String.valueOf(num).toCharArray(); // &&&
        int n = arr.length;

        int pre = 1, cur = 1;
        for (int i=1; i<n; i++) {
            //int sum = pre + cur;
            int sum = arr[i-1] == '1' || arr[i-1] == '2' && arr[i] < '6' ? pre + cur : cur;
            pre = cur;
            cur = sum;
        }

        return cur;
    }

    public static void main(String[] args) {
        O46 o = new O46();
        var res = o.translateNum(12258);
        System.out.println(res);
    }
}
