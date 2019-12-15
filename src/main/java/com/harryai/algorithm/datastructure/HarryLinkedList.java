package com.harryai.algorithm.datastructure;

import java.util.Iterator;

/**
 * @author Harry
 * @since 2019/9/16 20:25
 */
public class HarryLinkedList<E> {
    transient int size = 0;
    private Node<E> first;
    private Node<E> last;

    public void reverse() {
        if (first == null) {
            return;
        }
        Node<E> head = new Node<>(null, null);
        Node<E> currentInsert = first;
        last = currentInsert;
        while (currentInsert != null) {
            currentInsert = headInsert(head, currentInsert);
        }
        first = head.next;
    }

    private Node<E> headInsert(Node<E> head, Node<E> currentInsert) {
        // 记录下个要插入的节点
        Node<E> nextInsert = currentInsert.next;
        // 将要插入节点的后继指向当前的第一个节点，即head的后继。
        currentInsert.next = head.next;
        // 将head的后继指向当前节点
        head.next = currentInsert;
        // 重置currentInsert
        currentInsert = nextInsert;
        return currentInsert;
    }

    public void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(null, e);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public Iterator<E> iterator() {
        return new ListItr();
    }

    @Override
    public String toString() {
        Iterator<E> iterator = iterator();
        if (!iterator.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (true) {
            E next = iterator.next();
            sb.append(next);
            if (!iterator.hasNext()) {
                return sb.append("]").toString();
            }
            sb.append(",");
        }
    }

    public void merge(HarryLinkedList<E> merge) {
        Node<E> head = new Node<>(null, null);
        Node<E> first1 = first;
        Node<E> first2 = merge.first;
        size=0;
        while (first1!=null || first2!=null) {
            size++;
            if (first1!=null && first2!=null){
                if ((Integer)first1.item < (Integer) first2.item) {
                    first1 = headInsert(head, first1);
                }else {
                    first2=headInsert(head,first2);
                }
            }else if (first1!=null){
                first1 = headInsert(head, first1);
            }else {
                first2=headInsert(head,first2);
            }
        }
        first=head.next;

    }

    static class Node<E> {
        E item;
        HarryLinkedList.Node<E> next;

        Node(HarryLinkedList.Node<E> next, E element) {
            this.item = element;
            this.next = next;
        }
    }

    public class ListItr implements Iterator<E> {
        Node<E> current;
        Node<E> next;
        private int nextIndex;

        ListItr() {
            next = first;
        }


        @Override
        public boolean hasNext() {

            return nextIndex < size;
        }

        @Override
        public E next() {
            current = next;
            next = next.next;
            nextIndex++;
            return current.item;

        }

    }


}
