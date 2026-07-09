# Set Matrix Zeroes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` integer matrix `matrix`, if an element is `0`, set its entire row and column to `0`'s.

You must do it in place.

 

 **Example 1:** 

```
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

```

 **Example 2:** 

```
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

```

 

 **Constraints:** 

- m == matrix.length
- n == matrix[0].length
- 1 <= m, n <= 200
- -231 <= matrix[i][j] <= 231 - 1

 

 **Follow up:** 

- A straightforward solution using O(mn) space is probably a bad idea.
- A simple improvement uses O(m + n) space, but still not the best solution.
- Could you devise a constant space solution?

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 98.56%)  
**Memory:** 47.8 MB (beats 25.45%)  
**Submitted:** 2026-07-09T14:04:45.187Z  

```java
class Solution{
    public void setZeroes(int [][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;


        int col0=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;

                    if(j!=0){
                    matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(matrix[0][0]==0){
            for(int j=0;j<n;j++) matrix[0][j]=0;
        }

        if(col0==0){
            for(int i=0;i<m;i++) matrix[i][0]=0;
        }

    }
}        

        // TC= O(2*n*m) but SC= O(n)+o(m)
//         boolean row[]=new boolean[m];
//         boolean col[]=new boolean[n];

//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]==0){
//                     row[i]=true;
//                     col[j]=true;
//                 }
//             }
//         }

//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if( row[i]==true || col[j]==true){
//                     matrix[i][j]=0;
//                 }
//             }
//         }
//     }
// }




//
// class Solution {
//     public void setZeroes(int[][] matrix) {
//             int rows = matrix.length;
//             int cols = matrix[0].length;

//             boolean firstRowZero = false;
//             boolean firstColZero = false;

//             // Step 1: Check if first row or column has zero
//             for (int i = 0; i < rows; i++) {
//                 if (matrix[i][0] == 0) {
//                     firstColZero = true;
//                     break;
//                 }
//             }

//             for (int j = 0; j < cols; j++) {
//                 if (matrix[0][j] == 0) {
//                     firstRowZero = true;
//                     break;
//                 }
//             }

//             // Step 2: Use first row and column to mark zeros
//             for (int i = 1; i < rows; i++) {
//                 for (int j = 1; j < cols; j++) {
//                     if (matrix[i][j] == 0) {
//                         matrix[i][0] = 0; // Mark corresponding row
//                         matrix[0][j] = 0; // Mark corresponding column
//                     }
//                 }
//             }

//             // Step 3: Set matrix cells to zero based on marks
//             for (int i = 1; i < rows; i++) {
//                 for (int j = 1; j < cols; j++) {
//                     if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                         matrix[i][j] = 0;
//                     }
//                 }
//             }

//             // Step 4: Handle first row and column
//             if (firstRowZero) {
//                 for (int j = 0; j < cols; j++) {
//                     matrix[0][j] = 0;
//                 }
//             }

//             if (firstColZero) {
//                 for (int i = 0; i < rows; i++) {
//                     matrix[i][0] = 0;
//                 }
//             }
//         }
//     }  


// here we have optimized that space
//     // optimized approach
//         // int col0 = 1;

//         // for(int i=0;i<mat.length;i++){
//         //     for(int j=0;j<mat[0].length;j++){
//         //         if(j!=0 && mat[i][j] == 0){
//         //             mat[i][0] = 0;
//         //             mat[0][j] = 0;
//         //         }else if(j == 0 && mat[i][j] == 0){
//         //             col0 = 0;
//         //         }
//         //     }
//         // }

//         // for(int i=1;i<mat.length;i++){
//         //     for(int j=1;j<mat[0].length;j++){
//         //         if(mat[i][0]==0||mat[0][j]==0){
//         //             mat[i][j] = 0;
//         //         }
//         //     }
//         // }

//         // if(mat[0][0]==0){
//         //     for(int j=0;j<mat[0].length;j++){
//         //         mat[0][j] = 0;
//         //     }
//         // }

//         // if(col0==0){
//         //     for(int i=0;i<mat.length;i++){
//         //         mat[i][0] = 0;
//         //     }
//         // }
    

```

---

[View on LeetCode](https://leetcode.com/problems/set-matrix-zeroes/)