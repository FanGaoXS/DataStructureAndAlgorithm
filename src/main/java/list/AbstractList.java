package list;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/20/16:51
 * @Description:
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * list大小
     */
    protected int size;

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    /**
     * index超出范围后的报错信息
     */
    private void indexOutOfBoundsException(int index){
        throw new IndexOutOfBoundsException("index="+index+", size="+size);
    }

    /**
     * 检查删改查元素的index
     */
    protected void checkIndex(int index){
        if (index<0 || index>=size) indexOutOfBoundsException(index);
    }

    /**
     * 检查增元素的index
     */
    protected void checkIndexForAdd(int index){
        if (index<0 || index>size) indexOutOfBoundsException(index);
    }

}
