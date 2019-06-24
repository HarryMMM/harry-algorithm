package com.harryai.algorithm;

import com.harryai.algorithm.Util.DataPrepareUtil;
import com.harryai.algorithm.Util.LogUtil;
import com.harryai.algorithm.Util.RandomUtil;
import com.harryai.algorithm.Util.TreeNodePrepareUtil;
import com.harryai.algorithm.algorithm.selfstudy.sort.QuickSort;
import com.harryai.algorithm.mode.TreeNode;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

}
