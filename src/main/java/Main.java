import fibonacci.Fibonacci;
import list.ArrayList;
import list.Student;
import utils.ITimeUtil;
import utils.TimeUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/10/16:01
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            students.add(new Student("wqk"+i,i+10));
        }
        students.add(0,new Student("test",10));
        System.out.println("students = " + students);

        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ints.add(i);
        }
        System.out.println("ints.contains(2) = " + ints.contains(2));

    }
}
