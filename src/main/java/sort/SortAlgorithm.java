package sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/10/16:36
 * @Description:
 */
public class SortAlgorithm {

    public static void main(String[] args) {

        Integer[] integers = {1,7,9,5,4,3,7,5};
        List<Integer> beforeSortList = Arrays.asList(integers);
        System.out.println("beforeSortList = " + beforeSortList); //排序前list

        List<Integer> afterSortList = SortAlgorithm.bubbleSortOptimization(beforeSortList);
        System.out.println("afterSortList = " + afterSortList); //排序后list

    }

    //冒泡排序
    public static List<Integer> bubbleSort(List<Integer> integerList) {
        int size = integerList.size();
        for (int i = 0; i < size-1 ; i++) {
            for (int j = 0; j < size-i-1 ; j++) {
                Integer integerJ = integerList.get(j);
                Integer integerJ_1 = integerList.get(j+1);
                if (integerJ>integerJ_1){ //如果a[j]>a[j+1]则互换位置
                    integerList.set(j+1,integerJ);
                    integerList.set(j, integerJ_1);
                }
            }
        }
        return integerList;
    }

    //优化后的冒泡排序
    public static List<Integer> bubbleSortOptimization(List<Integer> integerList) {
        int size = integerList.size();
        boolean flag = true;
        for (int i = 0; i < size-1 ; i++) {
            for (int j = 0; j < size-i-1 ; j++) {
                Integer integerJ = integerList.get(j);
                Integer integerJ_1 = integerList.get(j+1);
                if (integerJ>integerJ_1){ //如果a[j]>a[j+1]则互换位置
                    flag = false;
                    integerList.set(j+1,integerJ);
                    integerList.set(j, integerJ_1);
                }
            }
            if (flag){
                break;
            }
        }
        return integerList;
    }

    //快速排序
    public static List<Integer> quickSort(List<Integer> integerList) {
        int pivot = integerList.get(0); //确定参照物为最左侧的元素
        return null;
    }

    //插入排序
    public static List<Integer> insertSort(List<Integer> integerList) {
        return null;
    }

}
