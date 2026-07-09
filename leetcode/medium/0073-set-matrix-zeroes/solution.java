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
    
