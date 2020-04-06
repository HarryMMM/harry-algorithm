package com.harryai.algorithm.selfstudy.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 归并排序
 *
 * @author Harry
 * @since 2019/9/14 20:56
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] la = {1, 3, 5, 7, 9, 13, 14};
        int[] lb = {2, 4, 6, 8, 10};
        int[] sort = new MergeSort().sort2(la, lb);

        System.out.println(ArrayUtils.toString(sort));
    }

    /**
     * 归并非递减的两个链表为非递增的一个链表，利用现有节点。
     *
     * @param a
     * @param b
     */
    public static <T extends Comparable<T>> LinkedList<T> merge(LinkedList<T> a, LinkedList<T> b) {
        Iterator<T> iterator = a.iterator();
        Iterator<T> iterator1 = b.iterator();
        LinkedList<T> c = new LinkedList<>();
        T next = null;
        T next1 = null;
        next = getNext(iterator, next);
        next1 = getNext(iterator1, next1);
        while (next != null || next1 != null) {
            if (next != null && next1 != null) {
                if (next.compareTo(next1) < 1) {
                    c.addFirst(next);
                    next = null;
                } else {
                    c.addFirst(next1);
                    next1 = null;
                }
            } else if (next != null) {
                c.addFirst(next);
                next = null;
            } else {
                c.addFirst(next1);
                next1 = null;
            }
            next = getNext(iterator, next);
            next1 = getNext(iterator1, next1);
        }
        return c;

    }

    private static <T extends Comparable<T>> T getNext(Iterator<T> iterator, T old) {
        T next = null;
        if (iterator.hasNext() && old == null) {
            next = iterator.next();
        } else {
            next = old;
        }
        return next;
    }

    /**
     * 删除a链表中 同样存在于b,c中的元素。
     *
     * @param a
     * @param b
     * @param c
     */
    public static <T extends Comparable<T>> void deleteOwnedByAll(LinkedList<T> a, LinkedList<T> b, LinkedList<T> c) {
        Iterator<T> aIter = a.iterator();
        Iterator<T> bIter = b.iterator();
        Iterator<T> cIter = c.iterator();

        T aNext = null;
        T bNext = null;
        T cNext = null;
        aNext = getNext(aIter, null);
        bNext = getNext(bIter, null);
        cNext = getNext(cIter, null);


        while (aNext != null && bNext != null && cNext != null) {
            if (aNext.compareTo(bNext)<0 ) {
                aNext = getNext(aIter, null);
            } else if (bNext.compareTo(cNext)<0) {
                bNext = getNext(bIter, null);
            } else if (cNext.compareTo( aNext)<0) {
                cNext = getNext(cIter, null);
            } else {
                aIter.remove();
                // 做了删除动作后，a指针向后移动
                aNext = getNext(aIter, null);
            }
        }
    }

    /**
     * 正序
     * 算法思想：
     * 1. 初始化临时表lc
     * 2. 比较la中最小的元素 和 lb 中最小的元素（由于la 和 lb升序，则从最开始移位一次比较），
     * 取最小的元素从前向后插入lc中
     * 3. 如果la 和 lc 不等长， 当最短的一个数组都放入lc中后，将另一个数组中未比较饿剩余的元素也
     * 依次放入lc中
     * 4. 返回lc
     *
     * @param la
     * @param lb
     * @return
     */
    public int[] sort(int[] la, int[] lb) {
        int aLen = la.length;
        int bLen = lb.length;
        int cLen = aLen + bLen;

        int[] lc = new int[cLen];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < aLen || j < bLen || k < cLen) {
            // 如果两个集合都没有遍历完，那么比较两个集合中的最小元素，将最小的放入lc
            if (i < aLen && j < bLen) {
                if (la[i] < lb[j]) {
                    lc[k++] = la[i++];
                } else {
                    lc[k++] = lb[j++];
                }
                // 如果两个集合有一个遍历完了，将没有遍历玩的元素继续加入lc中
            } else {
                if (i < aLen) {
                    lc[k++] = la[i++];
                } else if (j < bLen) {
                    lc[k++] = lb[j++];
                    // 如果都遍历完了，结束。
                } else {
                    break;
                }

            }
        }
        return lc;
    }

    /**
     * 反序
     * 算法思想：
     * 1. 初始化临时表lc
     * 2. 比较la中最小的元素 和 lb 中最小的元素（由于la 和 lb升序，则从最开始移位一次比较），
     * 取最小的元素从后向前插入lc中
     * 3. 如果la 和 lc 不等长， 当最短的一个数组都放入lc中后，将另一个数组中未比较饿剩余的元素也
     * 依次放入lc中
     * 4. 返回lc
     *
     * @param la
     * @param lb
     * @return
     */
    public int[] sort2(int[] la, int[] lb) {
        int aLen = la.length;
        int bLen = lb.length;
        int cLen = aLen + bLen;

        int[] lc = new int[cLen];
        int i = 0;
        int j = 0;
        int k = cLen - 1;
        while (i < aLen || j < bLen || k < cLen) {
            // 如果两个集合都没有遍历完，那么比较两个集合中的最小元素，将最小的放入lc
            if (i < aLen && j < bLen) {
                if (la[i] < lb[j]) {
                    lc[k--] = la[i++];
                } else {
                    lc[k--] = lb[j++];
                }
                // 如果两个集合有一个遍历完了，将没有遍历玩的元素继续加入lc中
            } else {
                if (i < aLen) {
                    lc[k--] = la[i++];
                } else if (j < bLen) {
                    lc[k--] = lb[j++];
                    // 如果都遍历完了，结束。
                } else {
                    break;
                }

            }
        }
        return lc;
    }

    /**
     * 反序
     * 算法思想：
     * 1. 初始化临时表lc
     * 2. 比较la中最大的元素 和 lb 中最大的元素（由于la 和 lb升序，则从最最后以为依次比较），
     * 取最大的元素仿佛lc中
     * 3. 如果la 和 lc 不等长， 当最短的一个数组都放入lc中后，将另一个数组中未比较的剩余的元素也
     * 依次放入lc中
     * 4. 返回lc
     *
     * @param la
     * @param lb
     * @return
     */
    public int[] sort3(int[] la, int[] lb) {
        int aLen = la.length;
        int bLen = lb.length;
        int cLen = aLen + bLen;
        int[] lc = new int[cLen];
        int i = aLen - 1;
        int j = bLen - 1;
        int k = 0;
        while (i >= 0 || j >= 0 || k < cLen) {
            // 如果两个集合都没有遍历完，那么比较两个集合中的最小元素，将最小的放入lc
            if (i >= 0 && j >= 0) {
                if (la[i] > lb[j]) {
                    lc[k++] = la[i--];
                } else {
                    lc[k++] = lb[j--];
                }
                // 如果两个集合有一个遍历完了，将没有遍历玩的元素继续加入lc中
            } else {
                if (i >= 0) {
                    lc[k++] = la[i--];
                } else if (j >= 0) {
                    lc[k++] = lb[j--];
                    // 如果都遍历完了，结束。
                } else {
                    break;
                }

            }
        }
        return lc;
    }
}
