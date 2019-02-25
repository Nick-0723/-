import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(solution1(1534236469));
    }

    public static int solution(int x) {
        StringBuffer sb = new StringBuffer(x+"");
        try {
            return sb.toString().startsWith("-")? - Integer.parseInt(sb.deleteCharAt(0).reverse().toString()) : Integer.parseInt(sb.reverse().toString());
        } catch (Exception e){
            return 0;
        }
    }

    public static int solution1(int x) {
        boolean fu = false;
        int y = x;
        int len = (x + "").length();
        if (x < 0){
            fu = true;
            y = -x;
            len -= 1;
        }
        List<Long> m = new ArrayList<>(); // 用来存倍数
        List<Long> n = new ArrayList<>(); // 存每个数字
        for (int i = 0; i < len; i++){
            m.add((long)y % 10);
            if (n.isEmpty()) n.add(1L); else n.add(n.get(i-1) * 10);
            y = y / 10;
        }

        long res = 0;
        for (int i = 0; i < m.size(); i++) {
            res += m.get(i) * n.get(m.size() - i - 1);
        }

        if (res > 2147483647 || res < -2147483648) {
            return 0;
        }


        return fu ? - (int)res : (int)res;
    }
}
