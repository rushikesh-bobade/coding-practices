class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int mid=0;
        int l=0;
        int r=m*n-1;
        while(l<=r){
            mid=l+(r-l)/2;

             // Convert 1D index to 2D coordinates
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
            
        }
        return false;
    }
}