package com.harryai.algorithm.leetcode.editor.en.utils;

import com.harryai.algorithm.leetcode.editor.en.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * <p>
 *
 * @author haorui.hao
 * @since 2023/03/05 13:25
 **/
public class BinaryTreeUtils {
    public static TreeNode arrays2Tree(Integer[] nums) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0, j = 1; i < nums.length; i++) {
            Integer num = nums[i];
            if (num == null) {
                continue;
            }
            TreeNode root = map.computeIfAbsent(i, (key) -> new TreeNode(num));
            if (j < nums.length ) {
                if (nums[j] != null) {
                    TreeNode left = new TreeNode(nums[j]);
                    root.left = left;
                    map.put(j, left);
                }
                j++;
            }
            if (j < nums.length) {
                if (nums[j] != null) {
                    TreeNode right = new TreeNode(nums[j]);
                    root.right = right;
                    map.put(j, right);
                }
                j++;
            }
        }
        return map.get(0);
    }
}
