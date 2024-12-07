class Solution {
    public int orangesRotting(int[][] grid) {
       return bfs(grid);
    }


    public int bfs(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int rowSize = grid.length;
        int colSize = grid[0].length;

        boolean isFreshFound = false;

        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    isFreshFound = true;
                }
            }
        }

        if(isFreshFound == false) {
            return 0;
        }

        int clock = -1;
        while (!queue.isEmpty()) {
            clock++;
            int sizeSnapshot = queue.size();
            while(sizeSnapshot>0) {
                int[] cords = queue.remove();
                int row = cords[0];
                int col = cords[1];

                int directions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                //all four side check for rotten
                for(int direction[] : directions) {
                    int dRow = direction[0];
                    int dCol = direction[1];

                    int newRow = row + dRow;
                    int newCol = col + dCol;
                    if(newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol <colSize && grid[newRow][newCol] == 1) {
                        queue.add(new int[]{newRow,newCol});
                        grid[newRow][newCol] = 0;
                    }
                }
                sizeSnapshot--;
            }

        }

        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return clock;
    }
}
