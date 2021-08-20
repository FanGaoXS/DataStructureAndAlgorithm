package list;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/20/12:05
 * @Description:
 */
public class LinkedList<E> extends AbstractList<E>{

    /**
     * 首节点
     */
    private Node<E> first;

    /**
     * 静态内部类
     */
    private static class Node<E>{

        /**
         * 该节点存储的元素
         */
        private E element;

        /**
         * 该节点所指向的下一个节点
         */
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 获取具体某一下标的节点
     * @param index      下标
     * @return           该下标的node节点
     */
    private Node<E> node(int index){
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        if (index == 0){
            first = new Node<>(element, first);
        } else {
            Node<E> pNode = node(index - 1);             //当前index的前一个节点
            pNode.next = new Node<>(element, pNode.next);      //当前节点的下一个节点赋给待添加的节点
        }
        size++;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> pNode = node(index - 1);
            Node<E> node = pNode.next;
            pNode.next = node.next;
        }
        size--;
    }

    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        node(index).element = element;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).element;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if ( (node.element).equals(element) ) return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("LinkedList{");
        string.append("size=" + size + ", elements=[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            string.append(node.element);
            node = node.next;
            if (i!=size-1){
                string.append(", ");
            }
        }
        string.append("]");
        string.append("}");
        return string.toString();
    }
}
