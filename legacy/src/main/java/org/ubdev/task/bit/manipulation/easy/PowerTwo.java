package org.ubdev.task.bit.manipulation.easy;

class PowerTwo {

    public boolean isPowerOfTwo1(int n) {
        if (n<=0)
            return false;
        while (n > 1) {
            if ((n&1)==1)
                return false;
            n/=2;
        }
        return true;
    }

    public boolean isPowerOfTwo2(int n) {
        long a = 1;
        while (a <= n) {
            if (a==n)
                return true;
            a*=2;
        }
        return false;
    }

    // Follow up
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&n-1) == 0;
    }
}
