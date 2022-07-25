package com.company;

public class WallsAndGates {
    private boolean isSafe(int i, int j, int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        if(i < 0 || j < 0 || i >= x || j >= y) {
            return false;
        }
        return true;
    }
    public void dfs(int i, int j, int[][] grid , int dist) {
        int [] rows_x = new int[]{-1,0,1,0};
        int [] rows_y = new int[]{0,1,0,-1};
        if(!isSafe(i , j, grid) || dist > grid[i][j]) {
            return;
        }
        grid[i][j] = dist;
        for(int k = 0; k < 4; k++) {
            if(isSafe(i + rows_x[k] , j + rows_y[k], grid)) {
                dfs(i + rows_x[k], j + rows_y[k], grid, dist + 1);
            }
        }
    }
    public static void main(String [] args) {
        WallsAndGates wallsAndGates = new WallsAndGates();
        int [][] input = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j] == 0) {
                    wallsAndGates.dfs(i, j, input, 0);
                }
            }
        }
        for (int i = 0; i < input[0].length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
