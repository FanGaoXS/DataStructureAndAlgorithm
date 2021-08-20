package list;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/20/12:05
 * @Description:
 */
public interface List<E> {

    /**
     * 动态数组大小
     * @return      动态数组大小
     */
    int size();

    /**
     * 动态数组是否为空
     * @return      动态数组是否为空
     */
    boolean isEmpty();

    /**
     * 添加元素
     * @param element   元素
     */
    void add(E element);

    /**
     *
     *  0 1 2 3 4 5 6 7 8 9
     *  1 2 3   4 5 6 7 8
     * 向指定位置添加元素
     * @param index     位置
     * @param element   元素
     */
    void add(int index,E element);

    /**
     *
     *  0 1 2 3 4 5 6 7 8 9
     *  a b c 1 d e f g h
     * 移除指定位置的元素
     * @param index     位置
     */
    void remove(int index);

    /**
     * 删除指定元素
     * @param element   元素
     */
    void remove(E element);

    /**
     * 清空动态数组中的元素
     */
    void clear();

    /**
     * 修改指定位置的元素
     * @param index      位置
     * @param element    元素
     */
    void set(int index,E element);

    /**
     * 获得指定位置的元素
     * @param index     位置
     * @return          元素
     */
    E get(int index);

    /**
     * 判断数组是否包含该元素
     * @param element    元素
     * @return           true包含，false不包含
     */
    boolean contains(E element);

    /**
     * 该元素第一次出现的下标
     * @param element    元素
     * @return           下标
     */
    int indexOf(E element);

}
