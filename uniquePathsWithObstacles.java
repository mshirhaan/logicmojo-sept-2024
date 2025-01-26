class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];

        return helper(obstacleGrid, 0, 0, memo);
    }
    public int helper(int[][] grid, int row, int col, int[][] memo){
        
        int rowlen = grid.length ;
        int collen = grid[0].length;
        if (grid[row][col] == 1){
        return 0;
        }

        if(row == rowlen -1 && col == collen -1){
            return 1;
        }

        if(memo[row][col] != 0) {
            return memo[row][col];
        }
        
        int rowVal = 0;
        int colVal = 0;
        if(row < rowlen -1 ){
            rowVal = helper(grid, row+1, col, memo);
        } 
        if(col < collen -1){
             colVal = helper(grid, row, col+1, memo);
        }
       
        memo[row][col] = rowVal+colVal;
        return rowVal+colVal;
    }
}
