package list;

import list.doubleLinked.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/16/15:15
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.remove(0);
        System.out.println("list = " + list);
    }
}
