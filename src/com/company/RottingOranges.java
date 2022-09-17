package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 *     0 representing an empty cell,
 *     1 representing a fresh orange, or
 *     2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Input: grid = [[0,2]]
 * Output: 0
 */
public class RottingOranges {
    public int[] row_x = {-1, 0, 1, 0 };
    public int[] row_y = { 0,-1, 0, 1};
    private boolean isNonRottenAdjacent(int x, int y, int[][] oranges) {
        int x_len = oranges.length;
        int y_len = oranges[0].length;
        if ((x < x_len) && (y < y_len) && (x >= 0) && (y >= 0) && (oranges[x][y] == 1)) {
            return true;
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int columns = grid[0].length;
        if(rows==0)
            return 0;
        if(columns==0)
            return 0;
        for (int i = 0; i < rows; ++i){
            for(int j = 0; j < columns; ++j){
                if((grid[i][j] == 2)) {
                    queue.add(new int[]{i,j});
                    grid[i][j] = 0;
                }
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int s = queue.size();
            while (s-- > 0) {
                int[] t = queue.poll();
                int x = t[0];
                int y = t[1];
                for (int k = 0; k < 4; k++) {
                    if (isNonRottenAdjacent(x + row_x[k], y + row_y[k], grid)) {
                        queue.add(new int[]{x + row_x[k],y + row_y[k]});
                        grid[x + row_x[k]][y + row_y[k]] = 0;
                    }
                }
            }
            count++ ;
        }

        for (int i = 0; i < grid.length; ++i){
            if (grid[0].length > 1) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            } else  {
                if ((grid[i][0] == 1)) {
                    return -1;
                }
            }
        }
        return count-1 > 0 ? count -1 : 0;
    }
    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int [][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        int [][] grid2 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        int [][] grid7 = {
                {2,1,1},
                {1,1,1},
                {0,1,2}
        };

        System.out.println("Number of minutes taken to Rotten orange for grid1 " + rottingOranges.orangesRotting(grid));
        int maxTime = rottingOranges.orangesRotting(grid2);
        System.out.println("Number of minutes taken to Rotten orange for grid2 " + maxTime);
        int [][] grid3 = {{0,2}};
        int [][] grid4 = {{1,2}};
        System.out.println("Number of minutes taken to Rotten orange for grid3 " + rottingOranges.orangesRotting(grid3));
        System.out.println("Number of minutes taken to Rotten orange for grid4 " + rottingOranges.orangesRotting(grid4));
        int [][] grid5 = {{0,1}};
        System.out.println("Number of minutes taken to Rotten orange for grid5 " + rottingOranges.orangesRotting(grid5));
        int [][] grid6 = {
                {2,0,1,1,1,1,1,1,1,1},
                {1,0,1,0,0,0,0,0,0,1},
                {1,0,1,0,1,1,1,1,0,1},
                {1,0,1,0,1,0,0,1,0,1},
                {1,0,1,0,1,0,0,1,0,1},
                {1,0,1,0,1,1,0,1,0,1},
                {1,0,1,0,0,0,0,1,0,1},
                {1,0,1,1,1,1,1,1,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}};

        System.out.println("Number of minutes taken to Rotten orange for grid6 " + rottingOranges.orangesRotting(grid6));
        System.out.println("Number of minutes taken to Rotten orange for grid7 " + rottingOranges.orangesRotting(grid7));
        for (int i = 0; i < grid7.length; ++i){
                for (int j = 0; j < grid7[0].length; ++j) {
                  System.out.print(grid7[i][j] + " ");
                }
                System.out.println();
        }


    }
}
