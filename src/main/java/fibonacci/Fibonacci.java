package fibonacci;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/13/17:49
 * @Description:
 */
public class Fibonacci {


    /**         0 1 2 3 4 5 6 7  8  9
     *          0 1 1 2 3 5 8 13 21 34 .....
     * 后一个数是前两个数之和
     */


    /**
     * 返回第number个斐波那契数
     * @param index    第几个
     * @return          斐波那契数
     */
    public static Integer getFibonacciNumber1(int index){
        if (index < 0) throw new RuntimeException("请输入大于等于0的数");
        if (index < 2) return index;
        return getFibonacciNumber1(index-1)+getFibonacciNumber1(index-2);
    }

    public static Integer getFibonacciNumber2(int index){
        if (index < 0) throw new RuntimeException("请输入大于等于0的数");
        if (index < 2) return index;
        int first = 0;
        int second = 1;
        for (int i = 0; i < index - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

}
