package basic.calc;


/**
 * 不用加法做加法
 *
 * 1. 异或 + 进位   <^ &>
 */
public class O65 {
    public int add(int a, int b) {
        int sum = 0;
        int carray = 0;

        do {
            sum = a ^ b;
            carray = (a & b) << 1;

            a = sum;
            b = carray;
        } while (b != 0);

        return sum;
    }

    public static void main(String[] args) {
        O65 o = new O65();
        var res = o.add(65, 70);
        System.out.println(res);
    }
}
