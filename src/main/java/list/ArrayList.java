package list;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/17/18:10
 * @Description:
 */
public class ArrayList<E> extends AbstractList<E> {

    /**
     * 动态数组
     */
    private E[] elements;

    /**
     * 动态数组默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;


    /**
     * 无参构造，创建默认大小的数组
     */
    public ArrayList(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 有参构造，根据容量创建数组
     * @param capacity      自定义容量
     */
    public ArrayList(int capacity){
        if (capacity<=0) capacity = DEFAULT_CAPACITY; //如果传入容量不为自然数，则强制为默认容量
        elements = (E[]) new Object[capacity];
    }

    /**
     * 确保容量（如果动态数组元素大小达到当前动态数组的容量满了则扩容）
     */
    private void ensureCapacity(){
        if (size == elements.length){ //如果动态数组得大小已经达到数组容量（已满）
            int nowCapacity = elements.length;                  //当前动态数组容量就是数组长度
            int newCapacity = nowCapacity + (nowCapacity >> 1); //扩容至当前容量得1.5倍
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) { //旧数组依次向新数组中赋值
                newElements[i] = elements[i];
            }
            elements = newElements;     //elements对象指向newElements
            System.out.println(nowCapacity + "扩容至" + newCapacity);
        }
    }

    public void add(E element){
        add(size,element);
    }

    public void add(int index,E element){
        if (element == null) throw new NullPointerException("不允许添加null");
        checkIndexForAdd(index);
        ensureCapacity();                     //确保数组容量（如果容量满了则扩容）
        for (int i = size; i > index ; i--) { //元素依次往后挪动
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < size-1 ; i++) { //元素依次往前挪
            elements[i] = elements[i+1];
        }
        elements[size-1] = null; //将数组的最后一个元素置为null
        size--;
    }

    public void remove(E element){
        remove(indexOf(element));
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void set(int index,E element){
        checkIndex(index);
        elements[index] = element;
    }

    public E get(int index){
        checkIndex(index);
        return elements[index];
    }

    public boolean contains(E element){
        return indexOf(element) >= 0;
    }

    public int indexOf(E element){
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return i; //如果element存在返回下标
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("ArrayList{");
        string.append("size=" + size + ", elements=[");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i != size -1) { //最后一个元素末尾不添加逗号
                string.append(", ");
            }
        }
        string.append("]");
        string.append("}");
        return string.toString();
    }

}
