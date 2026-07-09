# Unique Paths II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` integer array `grid`. There is a robot initially located at the  **top-left corner**  (i.e., `grid[0][0]`). The robot tries to move to the  **bottom-right corner**  (i.e., `grid[m - 1][n - 1]`). The robot can only move either down or right at any point in time.

An obstacle and space are marked as `1` or `0` respectively in `grid`. A path that the robot takes cannot include  **any**  square that is an obstacle.

Return  *the number of possible unique paths that the robot can take to reach the bottom-right corner*.

The testcases are generated so that the answer will be less than or equal to `2 * 109`.

 

 **Example 1:** 

```
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

```

 **Example 2:** 

```
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

```

 

 **Constraints:** 

- m == obstacleGrid.length
- n == obstacleGrid[i].length
- 1 <= m, n <= 100
- obstacleGrid[i][j] is 0 or 1.

## Solution

**Language:** TypeScript  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 55.3 MB (beats 78.89%)  
**Submitted:** 2026-07-09T13:20:28.010Z  

```ts
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
```

---

[View on LeetCode](https://leetcode.com/problems/unique-paths-ii/)