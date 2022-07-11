package com.company;

public class NumberOfIslands {
    //private static final int[] row = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] row =    {-1, 0, 1, 0 };
    private static final int[] column = { 0,-1, 0, 1};
    //private static final int[] column = { -1, 0, 1, -1, 1, -1, 0, 1 };

    boolean isSafe(int i, int j, int row, int column, boolean [][] visited, String [][] grid) {
        return ((i >=0 ) && (i < row) && (j >= 0) && (j < column) && (grid[i][j] == "1") && !visited[i][j]);
    }

    void dfs(String [][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k++){
            if(isSafe(i + row[k],j + column[k], grid.length, grid[0].length, visited, grid))
                dfs(grid, i + row[k],j + column[k], visited);
        }
    }

    public int countIslands(String[][] grid){
        int rows = grid.length;
        int columns = grid[0].length;
       /* if(i < 0 && i > m && j < 0 && j > n) {
            return;
        }
        if(grid[i][j] == "X") {
            return;
        }
        if(grid[i][j] == "0") {
            return;
        }
        if(grid[i][j] == "1") {
            count =  1;
            grid[i][j] = "X";
            countIslands(i + 1, j, grid, count);
            countIslands(i - 1, j, grid, count);
            countIslands(i, j + 1, grid, count);
            countIslands(i, j -1, grid, count);*//*
        }*/
        boolean visited [][] = new boolean[rows][columns];
        int count = 0;
        for (int i = 0; i < rows; ++i){
            for(int j = 0; j < columns; ++j){
                if((grid[i][j].equals("1")) && (!visited[i][j])) {
                    dfs(grid, i, j, visited);
                    count = count + 1;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();

        String [][] grid = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };
        String [][] grid1 = {
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
        };

        String [][] grid2 =
                { { "1", "1", "0", "0", "0" },
            { "0", "1", "0", "0", "1" },
            { "1", "0", "0", "1", "1" },
            { "0", "0", "0", "0", "0" },
            { "1", "0", "1", "0", "1" } };
        //System.out.println(grid[0][0]);
        //islands.countIslands(grid);
        System.out.println("Number of islands grid " +  islands.countIslands(grid));
        System.out.println("Number of islands grid1 " +  islands.countIslands(grid1));
        System.out.println("Number of islands grid2 " +  islands.countIslands(grid2));
    }
}
