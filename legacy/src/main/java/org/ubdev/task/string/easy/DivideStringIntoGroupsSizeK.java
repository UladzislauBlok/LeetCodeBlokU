package org.ubdev.task.string.easy;

class DivideStringIntoGroupsSizeK {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length() / k;
        if (s.length() % k != 0)
            n++;
        String[] partitions = new String[n];
        for (int i = 0; i < n; i++) {
            int start = i * k;
            int end = start + k;
            String partition;
            if (end > s.length()) {
                partition = s.substring(start, s.length());
                String filler = String.valueOf(fill).repeat(end - s.length());
                partition = partition + filler;
            } else {
                partition = s.substring(start, end);
            }
            partitions[i] = partition;
        }
        return partitions;
    }
}
