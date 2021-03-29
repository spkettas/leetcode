package array;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 1. ^=
 * xor a, a
 */
public class L136 {
    public int singleNumber(int[] nums) {
        int single = 0;

        for (int num : nums) {
            single ^= num;
        }

        return single;
    }

    public static void main(String[] args) {
        int[] nums ={4,1,2,1,2};

        L136 l = new L136();
        var res = l.singleNumber(nums);
        System.out.println(res);
    }
}
