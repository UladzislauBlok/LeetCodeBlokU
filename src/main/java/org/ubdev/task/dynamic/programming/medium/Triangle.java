package org.ubdev.task.dynamic.programming.medium;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.getFirst().getFirst();
        int lvl = 2;
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).getFirst();
            for (int j = 1; j < lvl - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][lvl - 1] = dp[i - 1][lvl - 2] + triangle.get(i).getLast();
            lvl++;
        }
        int min = Integer.MAX_VALUE;
        for (int result : dp[triangle.size() - 1]) {
            min = Math.min(min, result);
        }
        return min;
    }

    /*
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return minPath(0,0,triangle,dp);
    }
    public int minPath(int row,int col, List<List<Integer>> triangle,int[][] dp){
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!=-1)
            return dp[row][col];
        int down = minPath(row+1,col,triangle,dp);
        int downRight = minPath(row+1,col+1,triangle,dp);
        return dp[row][col] = triangle.get(row).get(col)+Math.min(down,downRight);
    }
     */
}
