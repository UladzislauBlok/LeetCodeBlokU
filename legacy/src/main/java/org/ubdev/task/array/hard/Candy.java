package org.ubdev.task.array.hard;

class Candy {

    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        res[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
        }
        int candy = 0;
        for (int i = 0; i < ratings.length; i++) {
            candy += res[i];
        }
        return candy;
    }
}
