func uniquePathsWithObstacles(obstacleGrid [][]int) int {
    m := len(obstacleGrid)
    n := len(obstacleGrid[0])

    dp := make([]int, n)

    // Starting position
    if obstacleGrid[0][0] == 1 {
        return 0
    }
    dp[0] = 1

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            // Obstacle blocks all paths through this cell
            if obstacleGrid[i][j] == 1 {
                dp[j] = 0
            } else if j > 0 {
                // Paths from top (dp[j]) + left (dp[j-1])
                dp[j] += dp[j-1]
            }
        }
    }

    return dp[n-1]
}