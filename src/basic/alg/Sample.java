package basic.alg;

import java.util.Random;

/**
 * 蓄水池抽样算法(大数据必备算法)
 *
 * 从一本很厚的电话本抽取100人进行姓氏统计
 *
 * 算法：
 * a. 准备k的池子，序列前k元素入池
 * b. k/n概率决定是否替换元素
 */
public class Sample {
    private static final int N = 10000;
    private Random rd = new Random();
    private int[] pool;

    public Sample() {
        pool = new int[N];

        for (int i=0; i<N; i++) {
            pool[i] = i;
        }
    }

    /**
     * N个样本中选取k个元素
     */
    public int[] sample(int k) {
        int[] result = new int[k];

        // 前k元素入数组
        for (int i=0; i<k; i++) {
            result[i] = pool[i];
        }

        // k+1个元素进行采样，p=k/n
        for (int i=k; i<N; i++) {
            int v = rd.nextInt(i+1);
            if (v < k) {
                result[v] = pool[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        var res = s.sample(10);
        for (var r : res) {
            System.out.println(r);
        }
    }
}
