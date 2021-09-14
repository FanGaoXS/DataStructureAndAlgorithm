package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/01/17:22
 * @Description:
 *
 *          1
 *          1  1
 *          1  2  1
 *          1  3  3  1
 *          1  4  6  4  1
 *          1  5  10 10 5  1
 *          1  6  15 20 15 6  1
 */
public class Solution {


    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>(numRows);
        ArrayList<Integer> preIntegers = null;
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> integers = new ArrayList<>(i);
            if (i == 1) {
                integers.add(1);
            } else {
                integers.add(0,1);          //第一个为1
                for (int j = 1; j < i-1; j++) { //该层除了第一个和最后一个（该层的j为上层的j和j-1的和）
                    integers.add(j,preIntegers.get(j)+preIntegers.get(j-1));
                }
                integers.add(i-1,1);    //最后一个为1
            }
            preIntegers = new ArrayList<>(integers);    //暂存这层（便于下一层循环中使用）
            lists.add(integers);
        }
        return lists;
    }


    public static void main(String[] args) {
        int numRows = 20;
        List<List<Integer>> lists = generate(numRows);
        lists.forEach(list-> System.out.println("list = " + list));
    }
}
