package org.ubdev.task.bit.manipulation.medium;

class SmallestSubarraysWithMaximumBitwiseOR {

    // O(32*N) = O(N)
    // It's important to understand task.
    // Max possible from current position. It's not always max overall
    // Max of OR is all possble bits equal to 1
    // Check all bits. Res = max of length of all bits
    // 1_000_000_000 is max is 30 bits
    public int[] smallestSubarrays1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[][] bits = new int[n][30];
        // init first (last) num
        String sb = Integer.toBinaryString(nums[n-1]);
        int idx = 29;
        for (int i = sb.length()-1; i >= 0; i--) {
            char b = sb.charAt(i);
            bits[n-1][idx] = b-'0';
            idx--;
        }
        res[n-1] = 1; // always
        for (int i = n-2; i >= 0; i--) {
            int max = 1;
            sb = Integer.toBinaryString(nums[i]);
            idx = 29;
            for (int j = sb.length()-1; j >= 0; j--) {
                char b = sb.charAt(j);
                int prev = bits[i+1][idx] == 0 ? 0 : bits[i+1][idx]+1;
                bits[i][idx] = b == '1' ? 1 : prev;
                max = Math.max(max, bits[i][idx]);
                idx--;
            }
            for (; idx >= 0; idx--) {
                bits[i][idx] = bits[i+1][idx] == 0 ? 0 : bits[i+1][idx]+1;
                max = Math.max(max, bits[i][idx]);
            }
            res[i] = max;
        }
        return res;
    }

    private int util(int n, int[] bits){
        int i = 0;
        int max = 1;
        while(i < 32){ // 32 bits int
            if((n&(1<<i)) != 0){
                bits[i] = 1;
            } else {
                bits[i] = bits[i] == 0 ? 0 : bits[i]+1;
            }
            max = Math.max(max, bits[i]);
            i++;
        }
        return max;
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] bits = new int[32];
        int[] res = new int[n];
        res[n-1] = 1;
        util(nums[n-1], bits);
        for (int i = n-2; i>=0; i--){
            res[i] = util(nums[i], bits);
        }
        return res;
    }
}
