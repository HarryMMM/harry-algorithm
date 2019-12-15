package com.harryai.algorithm;

import com.harryai.algorithm.Util.DataPrepareUtil;
import com.harryai.algorithm.Util.LogUtil;
import com.harryai.algorithm.Util.RandomUtil;
import com.harryai.algorithm.Util.TreeNodePrepareUtil;
import com.harryai.algorithm.algorithm.selfstudy.sort.MergeSort;
import com.harryai.algorithm.algorithm.selfstudy.sort.QuickSort;
import com.harryai.algorithm.mode.algorithm.TreeNode;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AlgorithmApplicationTests {
    private static Integer[] data = DataPrepareUtil.prepareNumberData(200000, RandomUtil.prepareInt(9));


    @Test
    public void sortNumber() {
//        System.out.println(Arrays.asList(data));
        long start = System.currentTimeMillis();
        Integer[] bubbleClone = data.clone();
        Integer[] timSortClone = data.clone();

        long cloneEnd = LogUtil.logCost("clone", start);
        QuickSort.sort(data, 0, data.length - 1);
//        System.out.println(Arrays.asList(data));
        long quickSortEnd = LogUtil.logCost("quick sort", cloneEnd);
//        BubbleSort.bubbleSort(bubbleClone);
//        long bubbleSortEnd = LogUtil.logCost("bubble sort", quickSortEnd);
        Arrays.sort(timSortClone);
        long timSortEnd = LogUtil.logCost("tim sort", quickSortEnd);
    }

    @Test
    public void sortObj() {
        List<TreeNode> treeNodesList = TreeNodePrepareUtil.prepareTreeNodesList(90);
        TreeNode[] treeNodesArray = treeNodesList.toArray(new TreeNode[treeNodesList.size()]);
        long start = System.currentTimeMillis();
        TreeNode[] timClone = SerializationUtils.clone(treeNodesArray);
        TreeNode[] quickClone = SerializationUtils.clone(treeNodesArray);

        long cloneEnd = LogUtil.logCost("clone", start);
        QuickSort.sort(quickClone, 0, quickClone.length - 1);
        long quickSortEnd = LogUtil.logCost("quick sort", cloneEnd);
        Arrays.sort(timClone);
        long timSortEnd = LogUtil.logCost("tim sort", quickSortEnd);
    }

    @Test
    public void test() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(8);
        linkedList.add(8);
        linkedList.add(10);
        linkedList.add(11);
        System.out.println(linkedList);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(1);
        linkedList2.add(4);
        linkedList2.add(6);
        linkedList2.add(6);
        linkedList2.add(8);
        linkedList2.add(9);
        linkedList2.add(10);
        System.out.println(linkedList2);

        LinkedList<Integer> linkedList3 = new LinkedList<>();
        linkedList3.add(4);
        linkedList3.add(5);
        linkedList3.add(6);
        linkedList3.add(7);
        linkedList3.add(8);
        linkedList3.add(9);
        linkedList3.add(10);

        System.out.println(linkedList3);


        MergeSort.deleteOwnedByAll(linkedList, linkedList2, linkedList3);
        System.out.println(linkedList);


    }

    @Test
    public void test33() {

//        int[] a = {20, 22, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17};
//        QuickSort.swapOddvenNumbers(a);
//        System.out.println(ArrayUtils.toString(a));
//
        Stream.of("Apsara", "2019", "9.25 - 9.27", "Digital Economy")
                .map(x -> 57 == x.charAt(0) ? "Here is the" :
                        50 == x.charAt(0) ? x.concat(":") : x)
                .reduce((x, y) -> x + " " + y)
                .ifPresent(System.out::println);

        int []a={1,2,3,4};
        String[] b = {"I", "am", "harry"};
        int reduce = Arrays.stream(a).reduce(1, Integer::sum);
        System.out.println(reduce);

    }

}
