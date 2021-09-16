package list.doubleLinked;

import list.AbstractList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/20/12:05
 * @Description:
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    private Node<E> last;

    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 双向链表可以根据index距离头节点更近或者尾节点更近来选择从那边开始迭代
     * @param index     下标
     * @return          node节点
     */
    private Node<E> node(int index){
        int halfSize = size >> 1;
        if (index<=halfSize) {//如果要访问的下标在前一半链表
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;   //依次往后迭代
            }
            return node;
        } else {//如果要访问的下标在后一半链表
            Node<E> node = last;
            for (int i = size-1; i > index ; i--) {
                node = node.prev;   //依次往前迭代
            }
            return node;
        }
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        if (size == 0) {    //链表中还没有任何元素（即即将添加的是第一个元素）
            Node<E> node = new Node<>(element, null, null);
            first = node;
            last = node;
        } else {    //链表中已经存在至少一个元素
            if (index == 0) {   //往第一个位置添加元素
                Node<E> oldFirst = first;
                Node<E> node = new Node<>(element, null, oldFirst);
                first = node;
                oldFirst.prev = node;
            } else if (index == size){  //往最后一个位置添加元素
                Node<E> oldLast = last; //原本的最后一个元素
                Node<E> node = new Node<>(element, oldLast, null);
                last = node;
                oldLast.next = node;
            } else {    //往中间添加元素
                Node<E> nextNode = node(index);//index位置的节点
                Node<E> prevNode = nextNode.prev;//index位置的前节点
                Node<E> node = new Node<>(element, prevNode, nextNode);//新加入的节点
                prevNode.next = node;
                nextNode.prev = node;
            }
        }
        size++;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (size == 1) {    //只有一个元素的时候
            first = null;
            last = null;
        } else {    //至少两个元素
            if (index == 0) {  //移除第一个元素
                first.next.prev = null;
                first = first.next;
            } else if (index == size -1) {  //移除最后一个元素
                last.prev.next = null;
                last = last.prev;
            } else {
                Node<E> indexNode = node(index);    //当前index的节点
                Node<E> prevNode = indexNode.prev;  //当前index的前一节点
                Node<E> nextNode = indexNode.next;  //当前index的后一节点
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
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
        last = null;
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

    public int lastIndexOf(E element) {
        Node<E> node = last;
        for (int i = size-1; i >= 0; i--) {
            if ( (node.element).equals(element) ) return i;
            node = node.prev;
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
