//Recursive, Top down, exponential
var uniquePaths = function(m, n) {
    return helper(0, 0);

    function helper(row, col) {
        if(row == m-1 && col == n-1) {
            return 1;
        }
        
        let right = 0
        let down = 0

        if(col<n-1) {
            right = helper(row, col+1)
        }
        
        if(row<m-1) {
            down = helper(row+1, col)
        }
        
        return right + down;

    }
};

//Recursive memoized
var uniquePaths = function(m, n) {
    return helper(0, 0, {});

    function helper(row, col, map) {

        if(map[row+","+col]!=undefined) {
            return map[row+","+col];
        }
        if(row == m-1 && col == n-1) {
            return 1;
        }
        
        let right = 0
        let down = 0

        if(col<n-1) {
            right = helper(row, col+1, map)
        }
        
        if(row<m-1) {
            down = helper(row+1, col, map)
        }

        map[row+","+col] = right + down;
        
        return right + down;

    }
};


//Tabular (bottom up) 
var uniquePaths = function(m, n) {
    let grid = [];
    for(let i = 0; i<m; i++) {
        grid[i] = [];
    }

    //fill the last row with 1
    for(let i = 0; i<n; i++) {
        grid[m-1][i] = 1;
    }

    //fill the last col with 1
    for(let i = 0; i<m; i++) {
        grid[i][n-1] = 1;
    }

    if(m < n) {
        //rows wise fill if rows are smaller than columns
        for(let i = m-2; i>=0; i--) {//from last but 1 row
            for(let j = n-2; j>=0;j--) { //from last but 1 col
                grid[i][j] = grid[i][j+1] + grid[i+1][j]
            }
        }
    } else {
        //columns wise fill if columns are smaller than rows
        for(let i = n-2; i>=0; i--) {//from last but 1 col
            for(let j = m-2; j>=0;j--) { //from last but 1 row
                grid[j][i] = grid[j][i+1] + grid[j+1][i]
            }
        }
    }

    return grid[0][0];
};

//Tabular (bottom up) space optimized
var uniquePaths = function(m, n) {
    if(m < n) {
        let rows = Array(m).fill(1);
        for(let i = m-2; i>=0; i--) {//from last but 1 row
            for(let j = n-2; j>=0;j--) { //from last but 1 col
                rows[j] = rows[j] + rows[j+1];
            }
        }
    } else {
        let rows = Array(n).fill(1);
        
        for(let i = n-2; i>=0; i--) {//from last but 1 col
            for(let j = m-2; j>=0;j--) { //from last but 1 row
                rows[j] = rows[j] + rows[j+1];
            }
        }
    }

    return grid[0][0];
};
