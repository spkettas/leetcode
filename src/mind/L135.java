package mind;


/**
 * 135.分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 1.左右遍历
 * f(n) = f(n-1) + 1
 */
public class L135 {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;

        int n = ratings.length;
        int[] left = new int[n];

        // 左边
        for (int i=0; i<n; i++) {
            if (i > 0 && ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;    // 比左边多
            } else {
                left[i] = 1;
            }
        }

        // 右边
        int ans = 0, right = 0;
        for (int i=n-1; i>=0; i--) {
           if (i < n-1 && ratings[i] > ratings[i+1]) {
               right++;
           } else {
               right = 1;
           }

           // &&& ans+=  -> left[i] right[i]
           ans += Math.max(left[i], right);
        }

        return ans;
    }

    public static void main(String[] args) {
        L135 l = new L135();
        var res = l.candy(new int[]{1,0,2});
        System.out.println(res);
    }
}
