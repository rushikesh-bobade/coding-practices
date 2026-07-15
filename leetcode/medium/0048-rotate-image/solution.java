class Solution {
    public void rotate(int[][] matrix) {
       int n=matrix.length;

        //taking transpose of the given matrix array
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                }
            }
        }

        //here reversing each row
       for(int i=0;i<n;i++){
        int left=0;
        int right=n-1;
        while(left<right){
            int temp=matrix[i][left];
            matrix[i][left]=matrix[i][right];
            matrix[i][right]=temp;
            left++;
            right--;
        }
       }
        


        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }

        // for (int i = 0; i < n; i++) {
        //     int left = 0, right = n - 1;
        //     while (left < right) {
        //         int temp = matrix[i][left];
        //         matrix[i][left] = matrix[i][right];
        //         matrix[i][right] = temp;
        //         left++;
        //         right--;
        //     }
        // }
    }
}