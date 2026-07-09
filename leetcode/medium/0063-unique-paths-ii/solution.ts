function uniquePathsWithObstacles(obstacleGrid: number[][]): number {
    const m = obstacleGrid.length;
    const n = obstacleGrid[0].length;

    const dp: number[] = new Array(n).fill(0);

    // Starting point
    dp[0] = obstacleGrid[0][0] === 1 ? 0 : 1;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            // If current cell is an obstacle, no path can pass through it
            if (obstacleGrid[i][j] === 1) {
                dp[j] = 0;
            } else if (j > 0) {
                // Add paths from the left cell
                dp[j] += dp[j - 1];
            }
        }
    }

    return dp[n - 1];
}