package com.harryai.algorithm.leetcode;

/**
 * @author Harry
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * @since 2019/12/15 21:15
 **/
public class No4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums2 = {1, 4, 7, 8, 9};
        int[] nums1 = {2, 3, 5, 6};
        System.out.println(new No4MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) return findMedianSortedArrays(new int[0], nums2);
        if (nums2 == null) return findMedianSortedArrays(nums1, new int[0]);
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums1[mid] < nums2[k - mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        double candidate1 = Math.min(l == m ? Integer.MAX_VALUE : nums1[l], k - l == n ? Integer.MAX_VALUE : nums2[k - l]);
        if ((m + n) % 2 == 1) return candidate1;
        double candidate2 = Math.max(l == 0 ? Integer.MIN_VALUE : nums1[l - 1], k - l == 0 ? Integer.MIN_VALUE : nums2[k - l - 1]);
        return (candidate1 + candidate2) / 2;
    }
//
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] largerArray;
//        int[] smallerArray;
//        if (nums1.length > nums2.length) {
//            largerArray = nums1;
//            smallerArray = nums2;
//        } else {
//            largerArray = nums2;
//            smallerArray = nums1;
//        }
//
//        int leftIndex = 0;
//        int rightIndexOfLargerArr = largerArray.length - 1;
//        int rightIndexOfSmallerArr = smallerArray.length - 1;
//        int smallest = 0;
//        int biggest = 0;
//        while (leftIndex <= largerArray.length - 1 && rightIndexOfLargerArr >= 0) {
//            int smallestTmp = leftIndex <= smallerArray.length-1
//                    ? Math.max(largerArray[leftIndex], smallerArray[leftIndex])
//                    : largerArray[leftIndex];
//            int biggestTmp = rightIndexOfSmallerArr >= 0
//                    ? Math.min(largerArray[rightIndexOfLargerArr], smallerArray[rightIndexOfSmallerArr])
//                    : largerArray[rightIndexOfLargerArr];
//
//            smallest = smallestTmp;
//            biggest = biggestTmp;
//
//            leftIndex++;
//            rightIndexOfLargerArr--;
//            rightIndexOfSmallerArr--;
//        }
//
//
//        return (smallest * 1.0 + biggest * 1.0) / 2;
//    }
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] nums3 = new int[nums1.length + nums2.length];
//        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
//        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
//        Arrays.sort(nums3);
//        System.out.println(Arrays.toString(nums3));
//        double leftIndex = 0;
//        double rightIndex = nums3.length - 1;
//        double mediumDouble = (leftIndex + rightIndex) / 2;
//        int mediumInt = (int) mediumDouble;
//        if (mediumInt * 1.0 == mediumDouble) {
//            return nums3[mediumInt];
//        } else {
//            int floor = (int) Math.floor(mediumDouble);
//            int ceil = (int) Math.ceil(mediumDouble);
//            return ((nums3[ceil]) * 1.0 + (nums3[floor]) * 1.0) / 2;
//        }
//    }
}
