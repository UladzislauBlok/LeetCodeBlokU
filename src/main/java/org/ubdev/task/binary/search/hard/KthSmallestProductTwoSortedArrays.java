package org.ubdev.task.binary.search.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestProductTwoSortedArrays {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Integer> A1 = new ArrayList<>();
        List<Integer> A2 = new ArrayList<>();
        List<Integer> B1 = new ArrayList<>();
        List<Integer> B2 = new ArrayList<>();

        separate(nums1, A1, A2);
        separate(nums2, B1, B2);

        long negCount = (long) A1.size() * B2.size() + (long) A2.size() * B1.size();
        int sign = 1;

        if (k > negCount) {
            k -= negCount;
        } else {
            k = negCount - k + 1;
            sign = -1;
            List<Integer> temp = B1;
            B1 = B2;
            B2 = temp;
        }

        long l = 0, r = (long) 1e10;
        while (l < r) {
            long m = (l + r) / 2;
            if (numProductNoGreaterThan(A1, B1, m) + numProductNoGreaterThan(A2, B2, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return sign * l;
    }

    private void separate(int[] nums, List<Integer> A1, List<Integer> A2) {
        for (int a : nums) {
            if (a < 0) {
                A1.add(-a);
            } else {
                A2.add(a);
            }
        }
        Collections.reverse(A1);
    }

    private long numProductNoGreaterThan(List<Integer> A, List<Integer> B, long m) {
        long count = 0;
        int j = B.size() - 1;
        for (int a : A) {
            while (j >= 0 && (long) a * B.get(j) > m) {
                j--;
            }
            count += j + 1;
        }
        return count;
    }
}
