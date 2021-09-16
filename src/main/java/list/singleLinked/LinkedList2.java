package list.singleLinked;

import list.AbstractList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/15/11:09
 * @Description:
 */
public class LinkedList2<E> extends AbstractList<E> {
    private Node<E> first;
    //private int size;
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E element,Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
    public LinkedList2(){
        //虚拟头节点
        first = new Node<E>(null,null);
    }

    private Node<E> node(int index){
        Node<E> node = first.next;
        if (index == -1) return first;
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
        checkIndex(index);
        Node<E> preNode = node(index - 1);
        preNode.next = new Node<>(element,preNode.next);
        size++;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        Node<E> preNode = node(index - 1);
        preNode.next = preNode.next.next;
        size--;
    }

    @Override
    public void remove(E element) {
        int index = indexOf(element);
        remove(index);
    }

    @Override
    public void clear() {
        first.next = null;
        size = 0;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.element = element;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.element;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first.next;
        for (int i = 0; i < size; i++) {
            if (node.element == element) return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("LinkedList{");
        string.append("size=" + size + ", elements=[");
        LinkedList2.Node<E> node = first.next;
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
