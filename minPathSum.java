class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return helper(0, 0, grid, memo);
    }

    public int helper(int i, int j, int[][] grid, int[][] memo) {
        if(memo[i][j] != 0) {
            return memo[i][j];
        } 

        int rowLimit = grid.length-1;
        int colLimit = grid[0].length-1;

        if(i==rowLimit && j == colLimit) {
            return grid[i][j];
        }
        
        int right = Integer.MAX_VALUE;
        if(j<colLimit) {
            right = helper(i, j+1, grid, memo); 
        }
        int bottom = Integer.MAX_VALUE;
        if(i<rowLimit) {
            bottom = helper(i+1, j, grid, memo);
        }

        memo[i][j] = grid[i][j] + Math.min(right, bottom);
        return memo[i][j];
    }
}
